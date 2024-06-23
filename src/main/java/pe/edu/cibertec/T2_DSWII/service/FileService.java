package pe.edu.cibertec.T2_DSWII.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@Service
public class FileService implements IFileService {

    private final Path pathFolder= Paths.get("uploads");

    private void validarExtension(String filename) throws Exception {
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        if (!List.of("pdf", "png", "docx").contains(extension)) {
            throw new Exception("Extensión de archivo invalida: " + extension);
        }
    }

    private void validarTamañoArchivo(MultipartFile archivo) throws Exception {
        if (archivo.getSize() > 25 * 1024 * 1024) {
            throw new Exception("El archivo a excedido de 25MB");
        }
    }

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        validarTamañoArchivo(archivo);
        Files.copy(archivo.getInputStream(), this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivoList) throws Exception {
        if (archivoList.size() != 3) {
            throw new Exception("Debes subir 3 archivos");
        }
        for (MultipartFile archivo : archivoList) {
            validarExtension(archivo.getOriginalFilename());
        }
        for (MultipartFile archivo : archivoList) {
            Files.copy(archivo.getInputStream(), this.pathFolder.resolve(archivo.getOriginalFilename()));
        }
    }
}
