package Controllers;

import dao.PredictionDAO;
import model.Prediction;

import java.util.List;
import java.util.Optional;

public class PredictionController {
    private PredictionDAO predictionDAO;

    public PredictionController() {
        this.predictionDAO = new PredictionDAO();
    }

    public List<Prediction> getPredictions() {
        return predictionDAO.getPredictions();
    }

    public Optional<Prediction> getPredictionById(int id) {
        return predictionDAO.getPredictionById(id);
    }

    public void addPrediction(Prediction prediction) {
        predictionDAO.addPrediction(prediction);
    }
}
