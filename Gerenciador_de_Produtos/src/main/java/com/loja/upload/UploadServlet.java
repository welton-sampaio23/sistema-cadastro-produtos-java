package com.loja.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.loja.dao.ProdutoDAO;
import com.loja.model.Produto;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try {
			Part filePart = request.getPart("arquivo");
			InputStream conteudoArquivo = filePart.getInputStream();
			BufferedReader leitor = new BufferedReader(new InputStreamReader(conteudoArquivo));
			
			String linha = null;
			ProdutoDAO dao = new ProdutoDAO();
			int produtosCadastrados = 0;
			
			while((linha = leitor.readLine()) != null) {
				String[] dados = linha.split("[,;]");
				int codigo = Integer.parseInt(dados[0].trim().replace("\"", ""));
				String nome = dados[1].trim();
				String marca = dados[2].trim();
				double preco = Double.parseDouble(dados[3].replace(",", ".").trim()); // Troca vírgula por ponto se precisar
				
				Produto produtoExistente = dao.buscarId(codigo);
				if(produtoExistente == null) {
					dao.cadastrar(codigo, nome, marca, preco);
					produtosCadastrados ++;
				} else {
					response.getWriter().print("Produto " + codigo + " já existe. Pulando...<br>");
					continue;
				}
			}
			
			if(produtosCadastrados > 0) {
				response.getWriter().print("Sucesso! " + produtosCadastrados + " produtos foram cadastrados.");
			} else {
				response.getWriter().print("<h3>Processo finalizado. Nenhum produto novo foi encontrado.</h3>");
			}
			response.getWriter().print("<br><a href='pages/listarPro.jsp'>Ver Lista</a>");
		} catch (Exception e) {
			response.getWriter().print("Erro ao processar arquivo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
