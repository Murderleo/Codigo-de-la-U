import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Desktop;
import java.io.File;

class BlackButton extends JButton {
    public BlackButton(String text) {
        super(text);
        setBackground(Color.WHITE); // Establece el color de fondo del botón
        setForeground(Color.BLACK); // Establece el color de las palabras del botón
    }
}

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String fileName) {
        backgroundImage = new ImageIcon(fileName).getImage();
    }// Carga la imagen de fondo

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this); //Dibuja la imagen de fondo en el panel
    }
}

public class MiVentana {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Mi Primera Ventana"); // Crea una ventana
                // Background panel for the main frame
                BackgroundPanel background = new BackgroundPanel("C:\\Users\\Usuario\\Documents\\1.Universidad\\Talleres\\Ciclo V\\POO II\\Imagen1.png");// Establece un panel de fondo con la imagen especificada
                frame.setContentPane(background); // Establece el panel de fondo como contenido de la ventana
                background.setLayout(new BorderLayout()); // Establece el diseño del panel de fondo

                JPanel buttonPanel = new JPanel(); // Crea un panel para los botones
                buttonPanel.setLayout(new FlowLayout());// Establece el diseño del panel de botones
                buttonPanel.setOpaque(false); // Establece el panel como transparente

                BlackButton libroButton = new BlackButton("El Juego del dinero_Libro");// Crea un botón "El Juego del dinero_Libro"
                BlackButton resumenButton = new BlackButton("Resumen");// Crea un botón "Resumen"

                Font buttonFont = new Font("Times New Roman", Font.PLAIN, 16);// Define una fuente para los botones
                libroButton.setFont(buttonFont);// Establece la fuente para el botón "El Juego del dinero_Libro"
                resumenButton.setFont(buttonFont); // Establece la fuente para el botón "Resumen"

                buttonPanel.add(libroButton); // Agrega el botón "El Juego del dinero_Libro" al panel
                buttonPanel.add(resumenButton); // Agrega el botón "Resumen" al panel

                frame.add(buttonPanel, BorderLayout.NORTH); // Agrega el panel de botone20s a la parte superior del marco

                BlackButton bancoPreguntaButton = new BlackButton("Banco De Pregunta"); // Crea un botón "Banco De Pregunta"
                bancoPreguntaButton.setFont(buttonFont); // Establece la fuente para el botón "Banco De Pregunta"

                frame.add(bancoPreguntaButton, BorderLayout.SOUTH); // Agrega el botón "Banco De Pregunta" a la parte inferior del marco

                libroButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String rutaArchivo = "C:\\Users\\Usuario\\Documents\\1.Universidad\\Talleres\\Ciclo V\\POO II\\El Juego del Dinero - Robert Kiyosaki.pdf";
                        try {
                            Desktop.getDesktop().open(new File(rutaArchivo)); // Abre el archivo PDF cuando se hace clic en el botón
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                resumenButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String rutaArchivo = "C:\\Users\\Usuario\\Documents\\1.Universidad\\Talleres\\Ciclo V\\POO II\\Sinopsis de EL JUEGO DEL DINERO.txt";
                        try {
                            Desktop.getDesktop().open(new File(rutaArchivo)); // Abre el archivo de texto cuando se hace clic en el botón
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                bancoPreguntaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BlackButton agregarPreguntaButton = new BlackButton("Agregar Pregunta"); // Crea un botón "Agregar Pregunta"
                        BlackButton mostrarPreguntaButton = new BlackButton("Mostrar Pregunta"); // Crea un botón "Mostrar Pregunta"
                        BlackButton volverButton = new BlackButton("Volver"); // Crea un botón "Volver"


                        agregarPreguntaButton.setFont(buttonFont); // Establece la fuente para el botón "Agregar Pregunta"
                        mostrarPreguntaButton.setFont(buttonFont); // Establece la fuente para el botón "Mostrar Pregunta"
                        volverButton.setFont(buttonFont); // Establece la fuente para el botón "Volver"

                        JPanel newButtonPanel = new JPanel(); // Crea un nuevo panel para los botones
                        newButtonPanel.setLayout(new FlowLayout()); // Establece el diseño del nuevo panel
                        newButtonPanel.setOpaque(false); // Establece el panel como transparente
                        newButtonPanel.add(agregarPreguntaButton); // Agrega el botón "Agregar Pregunta" al nuevo panel
                        newButtonPanel.add(mostrarPreguntaButton); // Agrega el botón "Mostrar Pregunta" al nuevo panel
                        newButtonPanel.add(volverButton); // Agrega el botón "Volver" al nuevo panel

                        frame.getContentPane().removeAll(); // Elimina todos los componentes del contenido del marco
                        frame.add(newButtonPanel, BorderLayout.CENTER); // Agrega el nuevo panel al centro del marco
                        frame.revalidate(); // Vuelve a validar la disposición del marco
                        frame.repaint(); // Vuelve a dibujar el marco

                        agregarPreguntaButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JLabel preguntaLabel = new JLabel("Pregunta:"); // Crea una etiqueta "Pregunta:"
                                JTextField preguntaField = new JTextField(20); // Crea un campo de texto para la pregunta

                                JLabel respuestaLabel = new JLabel("Respuesta:"); // Crea una etiqueta "Respuesta:"
                                JTextField respuestaField = new JTextField(20); // Crea un campo de texto para la respuesta

                                BlackButton guardarButton = new BlackButton("Guardar"); // Crea un botón "Guardar"
                                BlackButton volverButton2 = new BlackButton("Volver"); // Crea un botón "Volver"

                                guardarButton.setFont(buttonFont); // Establece la fuente para el botón "Guardar"
                                volverButton2.setFont(buttonFont); // Establece la fuente para el botón "Volver"

                                JPanel preguntaPanel = new JPanel(); // Crea un nuevo panel para la pregunta
                                preguntaPanel.setLayout(new FlowLayout()); // Establece el diseño del nuevo panel
                                preguntaPanel.setOpaque(false); // Establece el panel como transparente
                                preguntaPanel.add(preguntaLabel); // Agrega la etiqueta "Pregunta:" al panel
                                preguntaPanel.add(preguntaField); // Agrega el campo de texto para la pregunta al panel
                                preguntaPanel.add(respuestaLabel); // Agrega la etiqueta "Respuesta:" al panel
                                preguntaPanel.add(respuestaField); // Agrega el campo de texto para la respuesta al panel
                                preguntaPanel.add(guardarButton); // Agrega el botón "Guardar" al panel
                                preguntaPanel.add(volverButton2); // Agrega el botón "Volver" al panel

                                frame.getContentPane().removeAll(); // Elimina todos los componentes del contenido del marco
                                frame.add(preguntaPanel, BorderLayout.CENTER); // Agrega el panel de pregunta al centro del marco
                                frame.revalidate(); // Vuelve a validar la disposición del marco
                                frame.repaint(); // Vuelve a dibujar el marco

                                guardarButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String pregunta = preguntaField.getText(); // Obtiene la pregunta ingresada por el usuario
                                        String respuesta = respuestaField.getText(); // Obtiene la respuesta ingresada por el usuario
                                        guardarDatos(pregunta, respuesta); // Llama al método para guardar la pregunta y la respuesta
                                    }
                                });

                                volverButton2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame.getContentPane().removeAll(); // Elimina todos los componentes del contenido del marco
                                        frame.add(newButtonPanel, BorderLayout.CENTER); // Agrega el panel de botones principal al centro del marco
                                        frame.revalidate(); // Vuelve a validar la disposición del marco
                                        frame.repaint(); // Vuelve a dibujar el marco
                                    }
                                });
                            }
                        });

                        mostrarPreguntaButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mostrarPreguntas();
                            }
                        });

                        volverButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.getContentPane().removeAll();
                                frame.add(buttonPanel, BorderLayout.NORTH);
                                frame.add(bancoPreguntaButton, BorderLayout.SOUTH);
                                frame.revalidate();
                                frame.repaint();
                            }
                        });
                    }
                });

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setVisible(true);
            }
        });
    }

    private static void guardarDatos(String pregunta, String respuesta) {
        String nombreArchivo = "preguntas.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write("Pregunta: " + pregunta + "\n");
            writer.write("Respuesta: " + respuesta + "\n");
            writer.write("-------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarPreguntas() {
        String nombreArchivo = "preguntas.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            mostrarDialogo("Preguntas y Respuestas", contenido.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarDialogo(String titulo, String mensaje) {
        JTextArea textArea = new JTextArea(mensaje);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.PLAIN_MESSAGE);
    }
}