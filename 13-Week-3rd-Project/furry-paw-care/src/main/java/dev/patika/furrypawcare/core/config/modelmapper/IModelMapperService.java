package dev.patika.furrypawcare.core.config.modelmapper;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();

}
