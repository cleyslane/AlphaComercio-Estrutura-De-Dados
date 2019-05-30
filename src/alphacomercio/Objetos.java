package alphacomercio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import modelos.Bairro;
import modelos.Cidade;
import modelos.Logradouro;
import modelos.UnidadeFederacao;

/**
 *
 * @author cleyslane
 */
public class Objetos {

    private final HashMap<String, UnidadeFederacao> ufs;
    private final HashMap<String, Logradouro> logs;

    public Objetos() {
        this.ufs = new HashMap<>();
        this.logs = new HashMap<>();
    }

    /*1 Teste - 10 segundos
      2 Teste - 10 segundos  
      3 Teste - 9 segundos
      Tempo de Execução - 9.7 segundos  
     */
    public void lerDados() throws IOException {
        try (BufferedReader arquivo = Files.newBufferedReader(Paths.get(
                "C:\\Users\\cleys\\Downloads\\ceps\\ceps.txt\\"))) {

            String linha;

            while ((linha = arquivo.readLine()) != null) {
                if (linha.split("\t").length == 4) {

                    String[] campos = linha.split("\t");
                    String[] ufCity = campos[1].split("/");

                    String cep = campos[0];
                    String nomeCidade = ufCity[0];
                    String siglaUF = ufCity[1];
                    String nomeBairro = campos[2];
                    String nomeLogradouro = campos[3];

                    Cidade city;
                    Bairro bai;
                    Logradouro log;
                    UnidadeFederacao unidadeF;

                    if (!ufs.containsKey(siglaUF)) {
                        unidadeF = new UnidadeFederacao(siglaUF);
                        city = new Cidade(nomeCidade, unidadeF);
                        bai = new Bairro(nomeBairro);

                        log = new Logradouro(cep, city, unidadeF, bai, nomeLogradouro);
                        bai.adicionarLogradouro(log);
                        city.adicionarBairros(bai);
                        unidadeF.adicionaCidade(city);

                        ufs.put(siglaUF, unidadeF);
                        this.logs.put(cep, log);

                    } else {
                        unidadeF = ufs.get(siglaUF);
                        if (!unidadeF.getCidades().containsKey(nomeCidade)) {
                            city = new Cidade(nomeCidade, unidadeF);
                            bai = new Bairro(nomeBairro);

                            log = new Logradouro(cep, city, unidadeF, bai, nomeLogradouro);
                            bai.adicionarLogradouro(log);
                            city.adicionarBairros(bai);
                            unidadeF.adicionaCidade(city);

                            this.logs.put(cep, log);

                        } else {
                            city = unidadeF.getCidades().get(nomeCidade);
                            if (!city.getBairros().containsKey(nomeBairro)) {
                                bai = new Bairro(nomeBairro);
                                log = new Logradouro(cep, city, unidadeF, bai, nomeLogradouro);

                                bai.adicionarLogradouro(log);
                                city.adicionarBairros(bai);

                                this.logs.put(cep, log);

                            } else {
                                bai = city.getBairros().get(nomeBairro);
                                log = new Logradouro(cep, city, unidadeF, bai, nomeLogradouro);

                                bai.adicionarLogradouro(log);

                                this.logs.put(cep, log);
                            }
                        }
                    }

                }
            }
        }
    }

    public void buscarCEP(String cep) {
        Logradouro log = this.logs.get(cep);
        System.out.println("Cidade: " + log.getCidade().getNomeCidade()
                + "/" + log.getUnidadeFederacao().getSiglaUnidadeFederacao());
        System.out.println("Bairro: " + log.getBairro().getNomeBairro());
        System.out.println("Logradouro: " + log.getNomeLogradouro());

    }

    public void buscarLogBairro() {
        String uf = JOptionPane.showInputDialog("Informe o UF");
        uf = uf.toUpperCase();

        if (this.ufs.containsKey(uf)) {
            UnidadeFederacao unid = this.ufs.get(uf);
            {
                String cidade = JOptionPane.showInputDialog("Cidade");

                if (unid.getCidades().containsKey(cidade)) {
                    Cidade cid = unid.getCidades().get(cidade);

                    String nomebairro = JOptionPane.showInputDialog("Bairro");

                    if (cid.getBairros().containsKey(nomebairro)) {
                        Bairro ba = cid.getBairros().get(nomebairro);

                        Set<String> chaves = ba.getLogradouros().keySet();
                        for (String chave : chaves) {
                            if (chave != null) {
                                System.out.println("CEP: "
                                        + ba.getLogradouros().get(chave).getCep());
                                System.out.println("Logradouro: "
                                        + ba.getLogradouros().get(chave).getNomeLogradouro()
                                );
                            }
                        }

                    } else {
                        System.out.println("Bairro não encontrado!");
                    }
                } else {
                    System.out.println("Cidade não encontrada!");
                }
            }
        } else {
            System.out.println("UF não encontrado!");
        }
    }

}
