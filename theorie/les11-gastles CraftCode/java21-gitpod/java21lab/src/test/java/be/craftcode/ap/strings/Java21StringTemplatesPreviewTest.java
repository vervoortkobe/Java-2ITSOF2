package be.craftcode.ap.strings;

import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class Java21StringTemplatesPreviewTest {

    Java21StringTemplatesPreview java21StringTemplatesPreview = new Java21StringTemplatesPreview();

    @Test
    void testSubtractString(){
        assertEquals("54 minus 33 equals 21", java21StringTemplatesPreview.subtractString(54, 33));
        Integer randX = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
        Integer randY = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
        assertEquals(randX + " minus " + randY + " equals " + (randX - randY), java21StringTemplatesPreview.subtractString(randX, randY));
    }

    @Test
    void testJSON() {
        //The resulting object of the happy path:
        String correctData = """
                        {
                            "name":   "john",
                            "phone":   "5556667777",
                            "address": "2001 Odyssey St"
                        };
                        """ ;
        JSONObject correctJSON = new JSONObject(correctData);

        //Happy path of unsafe method. No problems here!
        assertTrue(correctJSON.similar(java21StringTemplatesPreview.userJSONUnsafe("john", "5556667777", "2001 Odyssey St")));

        //Uh oh, the user wrote some quotes into their input strings. They cause the JSONObject constructor to throw an error:
        JSONException exception = assertThrows(JSONException.class, () -> java21StringTemplatesPreview.userJSONUnsafe("jo\"hn", "555\"6667\"77\"7", "20\"01 Ody\"ssey \"St"));

        //This is the error. This is bad, but not as bad as the next problem.
        assertTrue(exception.getMessage().contains("Expected a ',' or '}' at"));

        //The resulting json object from a malicious injection
        String injectedData = """
                        {
                            "name":   "john",
                            "phone":   "5556667777",
                            "address": "2001 Odyssey St",
                            "injected":"should have sanitized lol"
                        };
                        """ ;
        JSONObject injectedJSON = new JSONObject(injectedData);

        //This is the worst case scenario, a user has injected an unexpected property and created a valid JSONObject that
        //can bounce around our code, causing havok!
        //If the attacker was clever, they could use this to force code to run on our server, eventually giving them complete access.
        assertTrue(injectedJSON.similar(java21StringTemplatesPreview.userJSONUnsafe("john\", \"injected\": \"should have sanitized lol", "5556667777", "2001 Odyssey St")));

        //This is the properly escaped result of our template processor that implements some validation
        //Now, instead of injecting a property, the user's name is just a very long, very weird, but now very harmless string:
        String escapedData = """
                        {
                            "name":   "john\\\", \\\"injected\\\": \\\"should have sanitized lol",
                            "phone":   "555\\\"6667\\\"77\\\"7",
                            "address": "20\\\"01 Ody\\\"ssey \\\"St"
                        };
                        """ ;
        JSONObject escapedJSON = new JSONObject(escapedData);

        assertTrue(escapedJSON.similar(java21StringTemplatesPreview.userJSON("john\", \"injected\": \"should have sanitized lol", "555\"6667\"77\"7", "20\"01 Ody\"ssey \"St")));
    }

    @Test
    void testProcessChant(){
        String happyPath ="""
                    Red and White: Loving colors
                    You always bring down the enemy
                    Because whatever happens
                    Our boys always stand firm;
                    Red and White: Let us repeat
                    You will triumph again today
                    And Sing, yes, sing along now all
                    Red and White, RAFC""";
        assertEquals(happyPath, java21StringTemplatesPreview.processChant("Red", "White", "RAFC"));

        String censored ="""
                    ****** and ******: Loving colors
                    You always bring down the enemy
                    Because whatever happens
                    Our boys always stand firm;
                    ****** and ******: Let us repeat
                    You will triumph again today
                    And Sing, yes, sing along now all
                    ****** and ******, ****""";
        assertEquals(censored, java21StringTemplatesPreview.processChant("Purple", "Purple", "KBVA"));
    }

}