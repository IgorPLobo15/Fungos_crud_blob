
package view;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Fungo;
import model.dao.FungoDAO;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Igor Lobo
 */
public class Fungos extends javax.swing.JFrame {
    private byte[] imagemParaCadastrar = null;
    private byte[] imagemParaAlterar = null;
    long tempoFinalInsertSort;
    long tempoFinalBubbleSort;
    long tempoFinalQuickSort;
        
    
    public static void insertionSort(int[] vetor_IS) {
        int i, j, chave;
        for (j = 1; j < vetor_IS.length; j++) {//percorre array
            chave = vetor_IS[j];//elemento copiado da posiçao j
            for (i = j - 1; (i >= 0) && (vetor_IS[i] > chave); i--) { //inicia loop na posicao anterior, e retrocede ate o incio
                                                                      //ate encontrar a posicao correta da chave
                                                                      // ou ate o vetor[i] ser menor ou igual a chave
                vetor_IS[i + 1] = vetor_IS[i];  //se maior que a chave vai para a direita                       
            }
            vetor_IS[i + 1] = chave; //serve para encontrar a posicao correta para inserir a chave
        }
    }
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        boolean troca;
        do {
            troca = false;
            for (int i = 1; i < n; i++) {
                if (vetor[i - 1] > vetor[i]) {//verifica se o elemento atual e menor que o anterior
                    // Troca os elementos
                    int temp = vetor[i - 1];
                    vetor[i - 1] = vetor[i];
                    vetor[i] = temp;
                    troca = true;
                }
            }
        } while (troca);
    }
    
    public static void quickSort(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);//inicia com argumentos inicias
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {//verifica se ha mais um elemento
            int posicaoPivo = particiona(vetor, inicio, fim);//chama a funcao para dividir o vetor em 2
            quickSort(vetor, inicio, posicaoPivo - 1);//recursiva para ordenar a esquerda
            quickSort(vetor, posicaoPivo + 1, fim);//recursiva para ordenar a direita
        }
    }

    private static int particiona(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;//aponta para o segundo elemento
        int j = fim; //aponta para o ultimo

        while (i <= j) {//enquanto i for menor ou igual a j
            if (vetor[i] <= pivo) {//avanca i enquanto o elemento no indice i for menor ou igual ao pivo
                i++;
            } else if (vetor[j] > pivo) {//decrementa j enquanto o j for maior q o pivo
                j--;
            } else {//se i nao for maior q j troca os elementos
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        //troca o pivo do elemento j
        int temp = vetor[inicio];
        vetor[inicio] = vetor[j];
        
        vetor[j] = temp;
        return j;// retorna nova posicao do pivo q sera usado para dividir o vetor em dois sub
        
    }
   

    
    private void exibirImagem(int id) {
    FungoDAO dao = new FungoDAO();
    byte[] imagemBytes = dao.getImagemById(id);

    if (imagemBytes != null) {
        ImageIcon imagem = new ImageIcon(imagemBytes);
        jLabelimagem.setIcon(imagem);
    } else {
        jLabelimagem.setIcon(null); // Limpa a imagem se não houver nenhuma.
    }
}
    
    
    

// public final class Clientes extends javax.swing.JFrame
  private static void setRowSorter(TableRowSorter tableRowSorter) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Fungos() {
        initComponents();      
         //ordena clicando no titulo da tabela
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
       
        tabela.setRowSorter(new TableRowSorter (modelo));
        readJTable();   
    }
    public void readJTable(){
       // atualização da Jtable
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);// sem este código, duplica as informações na tabela toda vez que fizer nova leitura
        FungoDAO cdao = new FungoDAO();
        
        for (Fungo f: cdao.read()){
            modelo.addRow(new Object[]{
                    f.getId(),
                    f.getNome(),
                    f.getNumero(),
                    f.getData()                   
                    });
            
        }
        
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Cadastrar = new javax.swing.JButton();
        Alterar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jTextID = new javax.swing.JTextField();
        jTextNome = new javax.swing.JTextField();
        jTextNumero = new javax.swing.JTextField();
        jTextData = new javax.swing.JTextField();
        jLabelimagem = new javax.swing.JLabel();
        btnSelecionarImagem = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();
        jButtonBubbleSort = new javax.swing.JButton();
        jButtonQuickSort = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        botaoComparar = new javax.swing.JButton();
        resultadoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("ID");

        jLabel2.setText("Nome");

        jLabel3.setText("Data");

        jLabel4.setText("Número");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        Alterar.setText("Alterar");
        Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlterarActionPerformed(evt);
            }
        });

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Cadastrar)
                .addGap(127, 127, 127)
                .addComponent(Alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLimpar)
                .addGap(167, 167, 167)
                .addComponent(Excluir)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Excluir)
                    .addComponent(Alterar)
                    .addComponent(Cadastrar)
                    .addComponent(jButtonLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Número", "Data"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jTextID.setBackground(new java.awt.Color(204, 204, 204));
        jTextID.setEnabled(false);

        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });

        jLabelimagem.setBackground(new java.awt.Color(204, 204, 204));
        jLabelimagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSelecionarImagem.setText("Selecionar");
        btnSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImagemActionPerformed(evt);
            }
        });

        jButtonInsert.setText("InsertSort");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonBubbleSort.setText("Bubble Sort");
        jButtonBubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBubbleSortActionPerformed(evt);
            }
        });

        jButtonQuickSort.setText("QuickSort");
        jButtonQuickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuickSortActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Execute todas as ordenações abaixo");

        botaoComparar.setText("Comparar");
        botaoComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCompararActionPerformed(evt);
            }
        });

        resultadoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        resultadoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelecionarImagem)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelimagem, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonBubbleSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonQuickSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botaoComparar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(resultadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(jTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabelimagem, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBubbleSort)
                        .addGap(9, 9, 9)
                        .addComponent(jButtonQuickSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoComparar)
                            .addComponent(resultadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTextData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelecionarImagem)
                        .addGap(26, 26, 26)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        Fungo f = new Fungo();
        FungoDAO dao = new FungoDAO();
        
        f.setNome(jTextNome.getText());
        f.setNumero(Integer.parseInt(jTextNumero.getText()));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Defina o formato da data
        Date data = null;
        try {
            data = sdf.parse(jTextData.getText());
        } catch (ParseException e) {           
        }
        f.setData(data);
        
         if (imagemParaCadastrar != null) {
        f.setImagem(imagemParaCadastrar); // Define a imagem selecionada no objeto Fungo
        dao.create(f); // Envie os dados, incluindo a imagem, para o banco de dados
        readJTable(); // Atualize a tabela
    } else {
        JOptionPane.showMessageDialog(null, "Selecione uma imagem antes de cadastrar.");
    }
        
        readJTable();

    }//GEN-LAST:event_CadastrarActionPerformed

    private void AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlterarActionPerformed
        if (tabela.getSelectedRow() != -1) {
        Fungo f = new Fungo();
        FungoDAO dao = new FungoDAO();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Defina o formato da data
        Date data = null;
        try {
            data = sdf.parse(jTextData.getText());
        } catch (ParseException e) {
        }
        f.setData(data);
        f.setId((int) tabela.getValueAt(tabela.getSelectedRow(), 0));
        f.setNome(jTextNome.getText());
        f.setNumero(Integer.parseInt(jTextNumero.getText()));
        
        if (imagemParaAlterar != null) {
            f.setImagem(imagemParaAlterar); // Define a nova imagem no objeto Fungo
            // Atualize a imagem no banco de dados
            dao.updateImagem(f.getId(), imagemParaAlterar);
        }
        // Atualize o objeto Fungo no banco de dados
        dao.update(f);

        // Atualize a tabela
        readJTable();
         
         
    
    }

    }//GEN-LAST:event_AlterarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        if (tabela.getSelectedRow()!= -1){
                    
        Fungo c = new Fungo();
        FungoDAO dao = new FungoDAO();
        c.setId((int)tabela.getValueAt(tabela.getSelectedRow(), 0));

        dao.delete(c);
        
        readJTable();
        
        jTextID.setText("");
        jTextNome.setText("");
        jTextNumero.setText("");
        jTextData.setText("");
        
        
      }  

    }//GEN-LAST:event_ExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        
        //adicona a linha da tabela que foi clicado nos JTextFields       
 if (tabela.getSelectedRow()!= -1){ //-1 representa que não selecionou a linha da tabela= indice -1
         jTextID.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
         jTextNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
         jTextNumero.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
         jTextData.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString()); 
         
         int id = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
        exibirImagem(id);
    }                                        
    else{
             jLabelimagem.setIcon(null);
            JOptionPane.showMessageDialog(null, "Selecione uma linha para ser alterada.");           
        } 
        
 

    }//GEN-LAST:event_tabelaMouseClicked

    private void btnSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImagemActionPerformed
         JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);

    int escolha = fileChooser.showOpenDialog(null);

    if (escolha == JFileChooser.APPROVE_OPTION) {
        File arquivoSelecionado = fileChooser.getSelectedFile();

        try {
            FileInputStream fileInputStream = new FileInputStream(arquivoSelecionado);
            byte[] imagemBytes = new byte[(int) arquivoSelecionado.length()];
            fileInputStream.read(imagemBytes);
            imagemParaCadastrar = imagemBytes;
            imagemParaAlterar = imagemBytes;
            // Defina uma variável global para a imagem selecionada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    jLabelimagem.setIcon(new ImageIcon(imagemParaCadastrar));
    jLabelimagem.setIcon(new ImageIcon(imagemParaAlterar));
        
    
    }//GEN-LAST:event_btnSelecionarImagemActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        FungoDAO fungoDAO = new FungoDAO();
        List<Fungo> fungos = fungoDAO.read();

        int tamanho = fungos.size();
        int[] vetorIS = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetorIS[i] = fungos.get(i).getNumero();
        }

        long tempoInicial = System.currentTimeMillis();
        insertionSort(vetorIS);
        long tempoFinal = System.currentTimeMillis();
        tempoFinalInsertSort = tempoFinal - tempoInicial;



        JOptionPane.showMessageDialog(null,"Tempo de ordenação = " + (tempoFinalInsertSort) + " ms" + "\n"+"Tempo de ordenação = " + (tempoFinalInsertSort) / 1000 + " s");


        for (int i = 0; i < vetorIS.length; i++) {
            System.out.println(" " + vetorIS[i]);
        }
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jButtonBubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBubbleSortActionPerformed
        FungoDAO fungoDAO = new FungoDAO();

        // Use o método da classe FungoDAO para buscar os dados do banco
        List<Fungo> fungos = fungoDAO.read();

        int tamanho = fungos.size();
        int[] vetorIS = new int[tamanho];

        // Preencha o vetor com os valores da coluna "numero"
        for (int i = 0; i < tamanho; i++) {
            vetorIS[i] = fungos.get(i).getNumero();
        }

        long tempoInicial = System.currentTimeMillis();
        bubbleSort(vetorIS); // Chama o Bubble Sort para ordenar os dados
        long tempoFinal = System.currentTimeMillis();
        tempoFinalBubbleSort=tempoFinal - tempoInicial;

        JOptionPane.showMessageDialog(null,"Tempo de ordenação = " + (tempoFinalBubbleSort) + " ms" + "\n"+"Tempo de ordenação = " + (tempoFinalBubbleSort) / 1000 + " s");

        for (int i = 0; i < vetorIS.length; i++) {
            System.out.println(" " + vetorIS[i]);
        }
    }//GEN-LAST:event_jButtonBubbleSortActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
         // Limpe os campos de texto definindo o texto como vazio
    jTextID.setText("");
    jTextNome.setText("");
    jTextNumero.setText("");
    jTextData.setText("");
    jLabelimagem.setIcon(null); // Limpa a imagem, se houver alguma

    // Certifique-se de limpar também a variável que armazena a imagem selecionada
    imagemParaAlterar = null;
    
    // Desselecione a linha na tabela
    tabela.clearSelection();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonQuickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuickSortActionPerformed
         FungoDAO fungoDAO = new FungoDAO();

        // Use o método da classe FungoDAO para buscar os dados do banco
        List<Fungo> fungos = fungoDAO.read();

        int tamanho = fungos.size();
        int[] vetorIS = new int[tamanho];

        // Preencha o vetor com os valores da coluna "numero"
        for (int i = 0; i < tamanho; i++) {
            vetorIS[i] = fungos.get(i).getNumero();
        }

        long tempoInicial = System.currentTimeMillis();
        quickSort(vetorIS); // Chama o Quick Sort para ordenar os dados
        long tempoFinal = System.currentTimeMillis();
        tempoFinalQuickSort=tempoFinal - tempoInicial;

        JOptionPane.showMessageDialog(null,"Tempo de ordenação = " + (tempoFinalQuickSort) + " ms" + "\n"+"Tempo de ordenação = " + (tempoFinalQuickSort) / 1000 + " s");

        for (int i = 0; i < vetorIS.length; i++) {
            System.out.println(" " + vetorIS[i]);
        }
        
    }//GEN-LAST:event_jButtonQuickSortActionPerformed

    private void botaoCompararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCompararActionPerformed
         if (tempoFinalInsertSort > 0 && tempoFinalBubbleSort > 0 && tempoFinalQuickSort > 0) {
        long menorTempo = Math.min(tempoFinalInsertSort, Math.min(tempoFinalBubbleSort, tempoFinalQuickSort));
        if (menorTempo == tempoFinalInsertSort) {
            resultadoLabel.setText("O mais rápido é o Insert Sort");
        } else if (menorTempo == tempoFinalBubbleSort) {
            resultadoLabel.setText("O mais rápido é o Bubble Sort");
        } else {
            resultadoLabel.setText("O mais rápido é o Quick Sort");
        }
        } else {
            resultadoLabel.setText("Primeiro execute os algoritmos de ordenação");
        }
    }//GEN-LAST:event_botaoCompararActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fungos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fungos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fungos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fungos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new Fungos().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alterar;
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton botaoComparar;
    private javax.swing.JButton btnSelecionarImagem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBubbleSort;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonQuickSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelimagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextData;
    private javax.swing.JTextField jTextID;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextNumero;
    private javax.swing.JLabel resultadoLabel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    
}
