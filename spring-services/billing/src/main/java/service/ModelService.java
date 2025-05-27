package service;

import entity.ModelEntity;
import entity.TokenUsageEntity;

import java.util.List;

public interface ModelService {
    ModelEntity createModel(ModelEntity ModelEntity);
    ModelEntity getModelById(Long id);
    ModelEntity updateModel(Long id, ModelEntity updatedModel);
    void deleteModel(Long id);
    List<ModelEntity> getAllModels();
    ModelEntity getModelByName(String name);
    List<TokenUsageEntity> getTokenUsagesForModel(Long modelId);
}
