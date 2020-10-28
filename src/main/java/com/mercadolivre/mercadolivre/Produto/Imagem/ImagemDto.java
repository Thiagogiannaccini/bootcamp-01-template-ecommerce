package com.mercadolivre.mercadolivre.Produto.Imagem;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

public class ImagemDto {

	private @NotNull @Size(min = 1) List<MultipartFile> imagens = new ArrayList<>();

	public void setImagens(List<MultipartFile> imagens) {
		this.imagens = imagens;
	}
	public List<MultipartFile> getImagens(){ 
		return imagens;
	}
}
