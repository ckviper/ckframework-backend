package service;

import entity.ModelEntity;
import entity.TokenUsageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ModelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Override
    public ModelEntity createModel(ModelEntity ModelEntity) {
        return null;
    }

    @Override
    public ModelEntity getModelById(Long id) {
        return null;
    }

    @Override
    public ModelEntity updateModel(Long id, ModelEntity updatedModel) {
        return null;
    }

    @Override
    public void deleteModel(Long id) {

    }

    @Override
    public List<ModelEntity> getAllModels() {
        return List.of();
    }

    @Override
    public ModelEntity getModelByName(String name) {
        return null;
    }

    @Override
    public List<TokenUsageEntity> getTokenUsagesForModel(Long modelId) {
        return List.of();
    }
}
