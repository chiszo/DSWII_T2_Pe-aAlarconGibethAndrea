package pe.edu.cibertec.T2_DSWII.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    void guardarArchivo(MultipartFile archivo) throws Exception;

    void guardarArchivos(List<MultipartFile> archivoList) throws Exception;
}
