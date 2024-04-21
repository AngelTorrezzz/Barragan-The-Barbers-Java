package Classes;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Collator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfazSecre extends javax.swing.JFrame {

    //Realiza la conexión a la BD
    Conexion conexion;   
    
    ArrayList nListaServicios = new ArrayList();
    ArrayList nListaProductos = new ArrayList();
    ArrayList nListaBarberos = new ArrayList();
    
    //Para poder mover la ventana
    private Point point;
    
    //27 Banderas para las horas (cada media hora)
    boolean tiempo1 = false;
    boolean tiempo2 = false;
    boolean tiempo3 = false;
    boolean tiempo4 = false;
    boolean tiempo5 = false;
    boolean tiempo6 = false;
    boolean tiempo7 = false;
    boolean tiempo8 = false;
    boolean tiempo9 = false;
    boolean tiempo10 = false;
    boolean tiempo11 = false;
    boolean tiempo12 = false;
    boolean tiempo13 = false;
    boolean tiempo14 = false;
    boolean tiempo15 = false;
    boolean tiempo16 = false;
    boolean tiempo17 = false;
    boolean tiempo18 = false;
    boolean tiempo19 = false;
    boolean tiempo20 = false;
    boolean tiempo21 = false;
    boolean tiempo22 = false;
    boolean tiempo23 = false;
    boolean tiempo24 = false;
    boolean tiempo25 = false;
    boolean tiempo26 = false;
    boolean tiempo27 = false;
    
    public InterfazSecre() {
        conexion = new Conexion("barraganthebarbers");
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        LlenarServicios();      //para que se llenen al cambiar de ventana
        LlenarProductos();      //para que se llenen al cambiar de ventana
        LlenarBarberos();       //para que se llenen al cambiar de ventana
        
        restringeNumeros(LeerPagoCon);
        //restringeChars(LeerAgendaCliente);
        
        //Fecha De Hoy
        Date fechaActual = new Date();
        String f;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        f = formatoFecha.format(fechaActual);   //Contiene la fecha de hoy
        FechaDeHoy.setText(f);
        FechaDeHoy.setEnabled(false);
        
        SeleccionarServicio.setVisible(false);
        SeleccionarProducto.setVisible(false);
        SeleccionarBarbero.setVisible(false);
        BotonConfirmarInsercion.setVisible(false);
        TextoAddServicios.setVisible(false);
        TextoAddProductos.setVisible(false);
        TextoAddBarberos.setVisible(false);
        ScrollAgenda.setVisible(false);
        BotonAgendaModificar.setVisible(false);
        BotonAgendaLimpiar.setVisible(false);
        BotonAsistencia.setVisible(false);
        BotonDesasistencia.setVisible(false);
        BotonAgendaAgregar.setVisible(false);
        BotonAgendaActualizar.setVisible(false);
        TextoAgendaCliente.setVisible(false);
        TextoAgendaBarbero.setVisible(false);
        TextoAgendaId.setVisible(false);
        LeerAgendaCliente.setVisible(false);
        TextoHoraAgenda.setVisible(false);
        SeleccionarHoraAgenda.setVisible(false);
        TextoServicioAgenda.setVisible(false);
        SeleccionarServicioAgenda.setVisible(false);
        TextoAgendaFecha.setVisible(false);
        RespuestaAgendaBarbero.setVisible(false);
        LeerAgendaFecha.setVisible(false);
        RespuestaAgendaId.setVisible(false);
        RespuestaAgendaIdBarbero.setVisible(false);
        SeleccionarAgendaBarbero.setVisible(false);
        BotonConfirmarAgenda.setVisible(false);
        ElegirAgendaFecha.setVisible(false);
        ScrollServiciosDia.setVisible(false);
        ScrollProductosDia.setVisible(false);
        SeleccionarMostrar.setVisible(false);
        BotonConfirmarMostrar.setVisible(false);
        TextoHoraAgenda.setVisible(false);
        SeleccionarHoraAgenda.setVisible(false);
        TextoServicioAgenda.setVisible(false);
        SeleccionarServicioAgenda.setVisible(false);
        TextoAgendaFecha.setVisible(false);
        BotonOjo.setVisible(false);
        TextoCitas.setVisible(false);
        Hora1.setVisible(false);
        Hora2.setVisible(false);
        Hora3.setVisible(false);
        Hora4.setVisible(false);
        Hora5.setVisible(false);
        Hora6.setVisible(false);
        Hora7.setVisible(false);
        Hora8.setVisible(false);
        Hora9.setVisible(false);
        Hora10.setVisible(false);
        Hora11.setVisible(false);
        Hora12.setVisible(false);
        Hora13.setVisible(false);
        Hora14.setVisible(false);
        Hora15.setVisible(false);
        Hora16.setVisible(false);
        Hora17.setVisible(false);
        Hora18.setVisible(false);
        Hora19.setVisible(false);
        Hora20.setVisible(false);
        Hora21.setVisible(false);
        Hora22.setVisible(false);
        Hora23.setVisible(false);
        Hora24.setVisible(false);
        Hora25.setVisible(false);
        Hora26.setVisible(false);
        Hora27.setVisible(false);
        TextoServiciosDuracion.setVisible(false);
        ScrollServiciosDuracion.setVisible(false);
        
        TextoCambioTotal.setVisible(false);
        RespuestaCambioTotal.setVisible(false);
        TextoPagoCon.setVisible(false);
        LeerPagoCon.setVisible(false);
        BotonCambio.setVisible(false);
        BotonOtraInsercion.setVisible(false);
        TextoCambio.setVisible(false);
        RespuestaCambio.setVisible(false);
        TextoServicioHecho.setVisible(false);
        RespuestaServicioHecho.setVisible(false);
        TextoProductoHecho.setVisible(false);
        RespuestaProductoHecho.setVisible(false);
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Icono1.png")); //Carga miniatura
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotonSalir = new javax.swing.JButton();
        BotonMinimizar = new javax.swing.JButton();
        BotonPerfil = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TextoCitas = new javax.swing.JLabel();
        Hora1 = new javax.swing.JLabel();
        Hora2 = new javax.swing.JLabel();
        Hora3 = new javax.swing.JLabel();
        Hora4 = new javax.swing.JLabel();
        Hora5 = new javax.swing.JLabel();
        Hora6 = new javax.swing.JLabel();
        Hora7 = new javax.swing.JLabel();
        Hora8 = new javax.swing.JLabel();
        Hora9 = new javax.swing.JLabel();
        Hora10 = new javax.swing.JLabel();
        Hora11 = new javax.swing.JLabel();
        Hora12 = new javax.swing.JLabel();
        Hora13 = new javax.swing.JLabel();
        Hora14 = new javax.swing.JLabel();
        Hora15 = new javax.swing.JLabel();
        Hora16 = new javax.swing.JLabel();
        Hora17 = new javax.swing.JLabel();
        Hora18 = new javax.swing.JLabel();
        Hora19 = new javax.swing.JLabel();
        Hora20 = new javax.swing.JLabel();
        Hora21 = new javax.swing.JLabel();
        Hora22 = new javax.swing.JLabel();
        Hora23 = new javax.swing.JLabel();
        Hora24 = new javax.swing.JLabel();
        Hora25 = new javax.swing.JLabel();
        Hora26 = new javax.swing.JLabel();
        Hora27 = new javax.swing.JLabel();
        TextoServicioHecho = new javax.swing.JLabel();
        RespuestaServicioHecho = new javax.swing.JLabel();
        TextoProductoHecho = new javax.swing.JLabel();
        RespuestaProductoHecho = new javax.swing.JLabel();
        TextoSecretaria = new javax.swing.JLabel();
        TextoPagoCon = new javax.swing.JLabel();
        LeerPagoCon = new javax.swing.JTextField();
        BotonCambio = new javax.swing.JButton();
        TextoCambio = new javax.swing.JLabel();
        RespuestaCambio = new javax.swing.JLabel();
        TextoServiciosDuracion = new javax.swing.JLabel();
        ScrollServiciosDuracion = new javax.swing.JScrollPane();
        TablaServiciosDuracion = new javax.swing.JTable();
        BotonOtraInsercion = new javax.swing.JButton();
        TextoCambioTotal = new javax.swing.JLabel();
        RespuestaCambioTotal = new javax.swing.JLabel();
        TextoBarraganThe = new javax.swing.JLabel();
        BotonInicio = new javax.swing.JButton();
        BotonInsertar = new javax.swing.JButton();
        BotonAgendaDeHoy = new javax.swing.JButton();
        SeleccionarProducto = new javax.swing.JComboBox<>();
        SeleccionarBarbero = new javax.swing.JComboBox<>();
        BotonConfirmarInsercion = new javax.swing.JButton();
        TextoAddServicios = new javax.swing.JLabel();
        TextoAddProductos = new javax.swing.JLabel();
        TextoAddBarberos = new javax.swing.JLabel();
        BotonServiciosDia = new javax.swing.JButton();
        ScrollAgenda = new javax.swing.JScrollPane();
        TablaAgenda = new javax.swing.JTable();
        BotonAgendaModificar = new javax.swing.JButton();
        BotonAgendaLimpiar = new javax.swing.JButton();
        BotonAsistencia = new javax.swing.JButton();
        BotonDesasistencia = new javax.swing.JButton();
        BotonAgendaAgregar = new javax.swing.JButton();
        BotonAgendaActualizar = new javax.swing.JButton();
        TextoAgendaCliente = new javax.swing.JLabel();
        TextoAgendaFecha = new javax.swing.JLabel();
        TextoHoraAgenda = new javax.swing.JLabel();
        TextoServicioAgenda = new javax.swing.JLabel();
        TextoAgendaBarbero = new javax.swing.JLabel();
        TextoAgendaId = new javax.swing.JLabel();
        BotonConfirmarAgenda = new javax.swing.JButton();
        LeerAgendaCliente = new javax.swing.JTextField();
        LeerAgendaFecha = new javax.swing.JTextField();
        SeleccionarHoraAgenda = new javax.swing.JComboBox<>();
        SeleccionarServicioAgenda = new javax.swing.JComboBox<>();
        RespuestaAgendaBarbero = new javax.swing.JTextField();
        RespuestaAgendaId = new javax.swing.JTextField();
        RespuestaAgendaIdBarbero = new javax.swing.JTextField();
        ScrollServiciosDia = new javax.swing.JScrollPane();
        TablaServiciosDia = new javax.swing.JTable();
        SeleccionarMostrar = new javax.swing.JComboBox<>();
        BotonConfirmarMostrar = new javax.swing.JButton();
        ScrollProductosDia = new javax.swing.JScrollPane();
        TablaProductosDia = new javax.swing.JTable();
        FechaDeHoy = new javax.swing.JLabel();
        SeleccionarAgendaBarbero = new javax.swing.JComboBox<>();
        ElegirAgendaFecha = new com.toedter.calendar.JDateChooser();
        BotonOjo = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1340, 700));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1340, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setMinimumSize(new java.awt.Dimension(1340, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(1340, 40));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonSalir.setBackground(new java.awt.Color(203, 67, 53));
        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Exit.png"))); // NOI18N
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 90, 30));

        BotonMinimizar.setBackground(new java.awt.Color(95, 106, 106));
        BotonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Minimize_1.png"))); // NOI18N
        BotonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 90, 30));

        BotonPerfil.setBackground(new java.awt.Color(95, 106, 106));
        BotonPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Perfil.png"))); // NOI18N
        BotonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(BotonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 40));

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setMinimumSize(new java.awt.Dimension(1450, 810));
        jPanel2.setPreferredSize(new java.awt.Dimension(1450, 810));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextoCitas.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        TextoCitas.setText("Citas Disponibles");
        jPanel2.add(TextoCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 270, 40));

        Hora1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora1.setText("9:00");
        jPanel2.add(Hora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

        Hora2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora2.setText("9:30");
        jPanel2.add(Hora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, -1, 30));

        Hora3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora3.setText("10:00");
        jPanel2.add(Hora3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 60, -1));

        Hora4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora4.setText("10:30");
        jPanel2.add(Hora4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 60, 30));

        Hora5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora5.setText("11:00");
        jPanel2.add(Hora5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 70, 30));

        Hora6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora6.setText("11:30");
        jPanel2.add(Hora6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 60, 30));

        Hora7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora7.setText("12:00");
        jPanel2.add(Hora7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 60, 30));

        Hora8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora8.setText("12:30");
        jPanel2.add(Hora8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 580, 60, 30));

        Hora9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora9.setText("13:00");
        jPanel2.add(Hora9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 60, 30));

        Hora10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora10.setText("13:30");
        jPanel2.add(Hora10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 60, 30));

        Hora11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora11.setText("14:00");
        jPanel2.add(Hora11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, 60, 30));

        Hora12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora12.setText("14:30");
        jPanel2.add(Hora12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, 60, -1));

        Hora13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora13.setText("15:00");
        jPanel2.add(Hora13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 60, 30));

        Hora14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora14.setText("15:30");
        jPanel2.add(Hora14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 60, 30));

        Hora15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora15.setText("16:00");
        jPanel2.add(Hora15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 60, 30));

        Hora16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora16.setText("16:30");
        jPanel2.add(Hora16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 60, 30));

        Hora17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora17.setText("17:00");
        jPanel2.add(Hora17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 60, 30));

        Hora18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora18.setText("17:30");
        jPanel2.add(Hora18, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 60, 30));

        Hora19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora19.setText("18:00");
        jPanel2.add(Hora19, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, -1, 30));

        Hora20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora20.setText("18:30");
        jPanel2.add(Hora20, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 60, 30));

        Hora21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora21.setText("19:00");
        jPanel2.add(Hora21, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, 60, 30));

        Hora22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora22.setText("19:30");
        jPanel2.add(Hora22, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 480, 60, -1));

        Hora23.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora23.setText("20:00");
        jPanel2.add(Hora23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 530, 60, 30));

        Hora24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora24.setText("20:30");
        jPanel2.add(Hora24, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, 60, 30));

        Hora25.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora25.setText("21:00");
        jPanel2.add(Hora25, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 430, -1, -1));

        Hora26.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora26.setText("21:30");
        jPanel2.add(Hora26, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, 60, 30));

        Hora27.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Hora27.setText("22:00");
        jPanel2.add(Hora27, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 530, -1, -1));

        TextoServicioHecho.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoServicioHecho.setText("Servicio:");
        jPanel2.add(TextoServicioHecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 100, 40));

        RespuestaServicioHecho.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jPanel2.add(RespuestaServicioHecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 350, 40));

        TextoProductoHecho.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoProductoHecho.setText("Producto:");
        jPanel2.add(TextoProductoHecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, 40));

        RespuestaProductoHecho.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jPanel2.add(RespuestaProductoHecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 350, 40));

        TextoSecretaria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TextoSecretaria.setForeground(new java.awt.Color(255, 255, 255));
        TextoSecretaria.setText("Secretaria");
        jPanel2.add(TextoSecretaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, -1, 28));

        TextoPagoCon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoPagoCon.setText("Pagó con:");
        jPanel2.add(TextoPagoCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 110, 40));

        LeerPagoCon.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        LeerPagoCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeerPagoConActionPerformed(evt);
            }
        });
        jPanel2.add(LeerPagoCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 120, 40));

        BotonCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Interrogacion.png"))); // NOI18N
        BotonCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCambioActionPerformed(evt);
            }
        });
        jPanel2.add(BotonCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 60, 40));

        TextoCambio.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoCambio.setText("Cambio:");
        jPanel2.add(TextoCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 90, 40));

        RespuestaCambio.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jPanel2.add(RespuestaCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 120, 40));

        TextoServiciosDuracion.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        TextoServiciosDuracion.setText("Servicios (Duracion)");
        jPanel2.add(TextoServiciosDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 320, -1));

        TablaServiciosDuracion.setBackground(new java.awt.Color(154, 125, 10));
        TablaServiciosDuracion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TablaServiciosDuracion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ScrollServiciosDuracion.setViewportView(TablaServiciosDuracion);

        jPanel2.add(ScrollServiciosDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1030, 150));

        BotonOtraInsercion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OKK.png"))); // NOI18N
        BotonOtraInsercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOtraInsercionActionPerformed(evt);
            }
        });
        jPanel2.add(BotonOtraInsercion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 560, 60, 40));

        TextoCambioTotal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoCambioTotal.setText("Total:");
        jPanel2.add(TextoCambioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 70, 40));

        RespuestaCambioTotal.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jPanel2.add(RespuestaCambioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 120, 40));

        TextoBarraganThe.setFont(new java.awt.Font("Times New Roman", 1, 38)); // NOI18N
        TextoBarraganThe.setForeground(new java.awt.Color(255, 255, 255));
        TextoBarraganThe.setText("Barragan The Barbers");
        jPanel2.add(TextoBarraganThe, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 400, 50));

        BotonInicio.setBackground(new java.awt.Color(95, 106, 106));
        BotonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar Inicio.png"))); // NOI18N
        BotonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInicioActionPerformed(evt);
            }
        });
        jPanel2.add(BotonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 80, 30));

        BotonInsertar.setBackground(new java.awt.Color(154, 125, 10));
        BotonInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Plus3.png"))); // NOI18N
        BotonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInsertarActionPerformed(evt);
            }
        });
        jPanel2.add(BotonInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 170, 70));

        BotonAgendaDeHoy.setBackground(new java.awt.Color(154, 125, 10));
        BotonAgendaDeHoy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diary.png"))); // NOI18N
        BotonAgendaDeHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgendaDeHoyActionPerformed(evt);
            }
        });
        jPanel2.add(BotonAgendaDeHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 170, 70));

        SeleccionarServicio.setBackground(new java.awt.Color(174, 182, 191));
        SeleccionarServicio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SeleccionarServicio.setMaximumRowCount(100);

        SeleccionarServicio.setBorder(null);
        SeleccionarServicio.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                SeleccionarServicioAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        SeleccionarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarServicioActionPerformed(evt);
            }
        });
        jPanel2.add(SeleccionarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 240, 50));

        SeleccionarProducto.setBackground(new java.awt.Color(174, 182, 191));
        SeleccionarProducto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SeleccionarProducto.setMaximumRowCount(100);
        SeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(SeleccionarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 250, 50));

        SeleccionarBarbero.setBackground(new java.awt.Color(174, 182, 191));
        SeleccionarBarbero.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SeleccionarBarbero.setMaximumRowCount(100);
        jPanel2.add(SeleccionarBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 260, 50));

        BotonConfirmarInsercion.setBackground(new java.awt.Color(202, 111, 30));
        BotonConfirmarInsercion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Palomita.png"))); // NOI18N
        BotonConfirmarInsercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarInsercionActionPerformed(evt);
            }
        });
        jPanel2.add(BotonConfirmarInsercion, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 170, 50));

        TextoAddServicios.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoAddServicios.setText("Servicios");
        jPanel2.add(TextoAddServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 90, 40));

        TextoAddProductos.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoAddProductos.setText("Productos");
        jPanel2.add(TextoAddProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 110, 40));

        TextoAddBarberos.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoAddBarberos.setText("Barberos");
        jPanel2.add(TextoAddBarberos, new org.netbeans.lib.awtextra.AbsoluteConstraints(683, 220, 100, 40));

        BotonServiciosDia.setBackground(new java.awt.Color(154, 125, 10));
        BotonServiciosDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tijeras2.png"))); // NOI18N
        BotonServiciosDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonServiciosDiaActionPerformed(evt);
            }
        });
        jPanel2.add(BotonServiciosDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 180, 70));

        TablaAgenda.setAutoCreateRowSorter(true);
        TablaAgenda.setBackground(new java.awt.Color(154, 125, 10));
        TablaAgenda.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TablaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ScrollAgenda.setViewportView(TablaAgenda);

        jPanel2.add(ScrollAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 970, 420));

        BotonAgendaModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cursor.png"))); // NOI18N
        BotonAgendaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgendaModificarActionPerformed(evt);
            }
        });
        jPanel2.add(BotonAgendaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 50, 420));

        BotonAgendaLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clean 2.png"))); // NOI18N
        BotonAgendaLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgendaLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(BotonAgendaLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 510, 40, -1));

        BotonAsistencia.setBackground(new java.awt.Color(241, 196, 15));
        BotonAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Palomita.png"))); // NOI18N
        BotonAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAsistenciaActionPerformed(evt);
            }
        });
        jPanel2.add(BotonAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 510, 30, 40));

        BotonDesasistencia.setBackground(new java.awt.Color(169, 50, 38));
        BotonDesasistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Remove 5.png"))); // NOI18N
        BotonDesasistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDesasistenciaActionPerformed(evt);
            }
        });
        jPanel2.add(BotonDesasistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 510, 30, 40));

        BotonAgendaAgregar.setBackground(new java.awt.Color(202, 111, 30));
        BotonAgendaAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Plus 4.png"))); // NOI18N
        BotonAgendaAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgendaAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(BotonAgendaAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 560, 80, 40));

        BotonAgendaActualizar.setBackground(new java.awt.Color(36, 113, 163));
        BotonAgendaActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Update.png"))); // NOI18N
        BotonAgendaActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgendaActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(BotonAgendaActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 560, 80, 40));

        TextoAgendaCliente.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoAgendaCliente.setText("Cliente:");
        jPanel2.add(TextoAgendaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 260, 80, 40));

        TextoAgendaFecha.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoAgendaFecha.setText("Fecha:");
        jPanel2.add(TextoAgendaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 410, -1, 40));

        TextoHoraAgenda.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoHoraAgenda.setText("Hora:");
        jPanel2.add(TextoHoraAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 310, -1, 40));

        TextoServicioAgenda.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoServicioAgenda.setText("Servicio:");
        jPanel2.add(TextoServicioAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 360, -1, 40));

        TextoAgendaBarbero.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoAgendaBarbero.setText("Barbero:");
        jPanel2.add(TextoAgendaBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 460, -1, 40));

        TextoAgendaId.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TextoAgendaId.setText("Id:");
        jPanel2.add(TextoAgendaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 510, 40, 40));

        BotonConfirmarAgenda.setBackground(new java.awt.Color(202, 111, 30));
        BotonConfirmarAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Palomita.png"))); // NOI18N
        BotonConfirmarAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarAgendaActionPerformed(evt);
            }
        });
        jPanel2.add(BotonConfirmarAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 80, 70));

        LeerAgendaCliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(LeerAgendaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 260, 170, 40));

        LeerAgendaFecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel2.add(LeerAgendaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 410, 170, 40));

        SeleccionarHoraAgenda.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SeleccionarHoraAgenda.setMaximumRowCount(30);
        SeleccionarHoraAgenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00" }));
        SeleccionarHoraAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarHoraAgendaActionPerformed(evt);
            }
        });
        jPanel2.add(SeleccionarHoraAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 310, 170, 40));

        SeleccionarServicioAgenda.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SeleccionarServicioAgenda.setMaximumRowCount(100);
        jPanel2.add(SeleccionarServicioAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 360, 170, 40));

        RespuestaAgendaBarbero.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        RespuestaAgendaBarbero.setForeground(new java.awt.Color(255, 0, 51));
        RespuestaAgendaBarbero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RespuestaAgendaBarberoActionPerformed(evt);
            }
        });
        jPanel2.add(RespuestaAgendaBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 460, 120, 40));

        RespuestaAgendaId.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        RespuestaAgendaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RespuestaAgendaIdActionPerformed(evt);
            }
        });
        jPanel2.add(RespuestaAgendaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 510, 40, 40));

        RespuestaAgendaIdBarbero.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        RespuestaAgendaIdBarbero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RespuestaAgendaIdBarberoActionPerformed(evt);
            }
        });
        jPanel2.add(RespuestaAgendaIdBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 460, 40, 40));

        TablaServiciosDia.setBackground(new java.awt.Color(154, 125, 10));
        TablaServiciosDia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TablaServiciosDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ScrollServiciosDia.setViewportView(TablaServiciosDia);

        jPanel2.add(ScrollServiciosDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 1080, 410));

        SeleccionarMostrar.setBackground(new java.awt.Color(174, 182, 191));
        SeleccionarMostrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SeleccionarMostrar.setMaximumRowCount(100);
        SeleccionarMostrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Servicios", "Productos" }));
        SeleccionarMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarMostrarActionPerformed(evt);
            }
        });
        jPanel2.add(SeleccionarMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 120, 30));

        BotonConfirmarMostrar.setBackground(new java.awt.Color(202, 111, 30));
        BotonConfirmarMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Palomita.png"))); // NOI18N
        BotonConfirmarMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmarMostrarActionPerformed(evt);
            }
        });
        jPanel2.add(BotonConfirmarMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 120, 30));

        TablaProductosDia.setBackground(new java.awt.Color(154, 125, 10));
        TablaProductosDia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TablaProductosDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ScrollProductosDia.setViewportView(TablaProductosDia);

        jPanel2.add(ScrollProductosDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 1080, 410));

        FechaDeHoy.setFont(new java.awt.Font("Times New Roman", 0, 26)); // NOI18N
        jPanel2.add(FechaDeHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 170, 50));

        SeleccionarAgendaBarbero.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SeleccionarAgendaBarbero.setMaximumRowCount(100);
        SeleccionarAgendaBarbero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarAgendaBarberoActionPerformed(evt);
            }
        });
        jPanel2.add(SeleccionarAgendaBarbero, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 150, 140, 30));
        jPanel2.add(ElegirAgendaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 140, 30));

        BotonOjo.setBackground(new java.awt.Color(133, 146, 158));
        BotonOjo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eye.png"))); // NOI18N
        BotonOjo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOjoActionPerformed(evt);
            }
        });
        jPanel2.add(BotonOjo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, 270, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoBarragan48px.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 610, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1340, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        conexion.Desconectar();
        System.exit(0);
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void BotonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInicioActionPerformed
        conexion.Desconectar();
        Interfaz vI = new Interfaz();
        vI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonInicioActionPerformed

    private void BotonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_BotonMinimizarActionPerformed

    private void BotonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonPerfilActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point = evt.getPoint();
        getComponentAt(point);
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int CurrentX = this.getLocation().x;
        int CurrentY = this.getLocation().y;
        
        int MoveX = (CurrentX + evt.getX()) - (CurrentX + point.x);
        int MoveY = (CurrentY + evt.getY()) - (CurrentY + point.y);
        
        int x = CurrentX + MoveX;
        int y = CurrentY + MoveY;
        
        this.setLocation(x,y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void SeleccionarServicioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SeleccionarServicioAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarServicioAncestorAdded

    private void BotonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInsertarActionPerformed
        BotonInsertar.setEnabled(false);
        BotonAgendaDeHoy.setEnabled(true);
        BotonServiciosDia.setEnabled(true);
        
        
        
        SeleccionarServicio.setVisible(true);
        SeleccionarProducto.setVisible(true);
        SeleccionarBarbero.setVisible(true);
        BotonConfirmarInsercion.setVisible(true);
        TextoAddServicios.setVisible(true);
        TextoAddProductos.setVisible(true);
        TextoAddBarberos.setVisible(true);
        
        ScrollAgenda.setVisible(false);
        BotonAgendaModificar.setVisible(false);
        BotonAgendaLimpiar.setVisible(false);
        BotonAsistencia.setVisible(false);
        BotonDesasistencia.setVisible(false);
        BotonAgendaAgregar.setVisible(false);
        BotonAgendaActualizar.setVisible(false);
        TextoAgendaCliente.setVisible(false);
        TextoAgendaBarbero.setVisible(false);
        TextoAgendaId.setVisible(false);
        LeerAgendaCliente.setVisible(false);
        TextoHoraAgenda.setVisible(false);
        SeleccionarHoraAgenda.setVisible(false);
        TextoServicioAgenda.setVisible(false);
        SeleccionarServicioAgenda.setVisible(false);
        TextoAgendaFecha.setVisible(false);
        BotonOjo.setVisible(false);
        TextoCitas.setVisible(false);
        Hora1.setVisible(false);
        Hora2.setVisible(false);
        Hora3.setVisible(false);
        Hora4.setVisible(false);
        Hora5.setVisible(false);
        Hora6.setVisible(false);
        Hora7.setVisible(false);
        Hora8.setVisible(false);
        Hora9.setVisible(false);
        Hora10.setVisible(false);
        Hora11.setVisible(false);
        Hora12.setVisible(false);
        Hora13.setVisible(false);
        Hora14.setVisible(false);
        Hora15.setVisible(false);
        Hora16.setVisible(false);
        Hora17.setVisible(false);
        Hora18.setVisible(false);
        Hora19.setVisible(false);
        Hora20.setVisible(false);
        Hora21.setVisible(false);
        Hora22.setVisible(false);
        Hora23.setVisible(false);
        Hora24.setVisible(false);
        Hora25.setVisible(false);
        Hora26.setVisible(false);
        Hora27.setVisible(false);
        TextoServiciosDuracion.setVisible(false);
        ScrollServiciosDuracion.setVisible(false);
        RespuestaAgendaBarbero.setVisible(false);
        LeerAgendaFecha.setVisible(false);
        RespuestaAgendaId.setVisible(false);
        RespuestaAgendaIdBarbero.setVisible(false);
        SeleccionarAgendaBarbero.setVisible(false);
        BotonConfirmarAgenda.setVisible(false);
        ElegirAgendaFecha.setVisible(false);
        ScrollServiciosDia.setVisible(false);
        ScrollProductosDia.setVisible(false);
        SeleccionarMostrar.setVisible(false);
        BotonConfirmarMostrar.setVisible(false);
    }//GEN-LAST:event_BotonInsertarActionPerformed

    private void BotonAgendaDeHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgendaDeHoyActionPerformed
        BotonAgendaDeHoy.setEnabled(false);
        BotonInsertar.setEnabled(true);
        BotonServiciosDia.setEnabled(true);
        
        
        SeleccionarAgendaBarbero.setVisible(true);
        BotonConfirmarAgenda.setVisible(true);
        ElegirAgendaFecha.setVisible(true);
        

        
        SeleccionarServicio.setVisible(false);
        SeleccionarProducto.setVisible(false);
        SeleccionarBarbero.setVisible(false);
        BotonConfirmarInsercion.setVisible(false);
        TextoAddServicios.setVisible(false);
        TextoAddProductos.setVisible(false);
        TextoAddBarberos.setVisible(false);
        ScrollServiciosDia.setVisible(false);
        ScrollProductosDia.setVisible(false);
        SeleccionarMostrar.setVisible(false);
        BotonConfirmarMostrar.setVisible(false);
        TextoCambioTotal.setVisible(false);
        RespuestaCambioTotal.setVisible(false);
        TextoPagoCon.setVisible(false);
        LeerPagoCon.setVisible(false);
        BotonCambio.setVisible(false);
        BotonOtraInsercion.setVisible(false);
        TextoCambio.setVisible(false);
        RespuestaCambio.setVisible(false);
        TextoServicioHecho.setVisible(false);
        RespuestaServicioHecho.setVisible(false);
        TextoProductoHecho.setVisible(false);
        RespuestaProductoHecho.setVisible(false);
    }//GEN-LAST:event_BotonAgendaDeHoyActionPerformed

    private void SeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarProductoActionPerformed

    private void SeleccionarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarServicioActionPerformed

    private void BotonConfirmarInsercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmarInsercionActionPerformed
        if(SeleccionarServicio.getSelectedItem().toString().equals("...") && SeleccionarProducto.getSelectedItem().toString().equals("..."))
            JOptionPane.showMessageDialog(null,"Seleccione Un Servicio O Un Producto.");
        else
            if(SeleccionarBarbero.getSelectedItem().toString().equals("..."))
                JOptionPane.showMessageDialog(null,"Seleccione Un Barbero.");
            else
                if(JOptionPane.showInternalConfirmDialog(null, "¿Confirmar Venta?") == 0)
                    if(!SeleccionarServicio.getSelectedItem().toString().equals("...") && !SeleccionarProducto.getSelectedItem().toString().equals("...")){
                        AgregarVentaServicio(true);
                        AgregarVentaProducto(true);
                        Servicios servicio = (Servicios) SeleccionarServicio.getSelectedItem();
                        Productos producto = (Productos) SeleccionarProducto.getSelectedItem();
                        float uno = servicio.getPrecio();
                        float dos = producto.getPrecio();
                        Cambio(uno,dos);
                        String servicioHecho = servicio.getServicio();
                        String productoHecho = producto.getProducto();
                        RespuestaServicioHecho.setText("$"+uno+" "+servicioHecho);
                        RespuestaProductoHecho.setText("$"+dos+" "+productoHecho);
                        
                        //LlenarServicios();
                        //LlenarProductos();
                        //LlenarBarberos();
                        SeleccionarServicio.setSelectedIndex(0);
                        SeleccionarProducto.setSelectedIndex(0);
                        SeleccionarBarbero.setSelectedIndex(0);
                    }else
                        if(!SeleccionarServicio.getSelectedItem().toString().equals("...") && SeleccionarProducto.getSelectedItem().toString().equals("...")){
                            AgregarVentaServicio(false);
                            Servicios servicio = (Servicios) SeleccionarServicio.getSelectedItem();
                            float uno = servicio.getPrecio();
                            Cambio(uno,0);
                            String servicioHecho = servicio.getServicio();
                            RespuestaServicioHecho.setText("$"+uno+" "+servicioHecho);
                            RespuestaProductoHecho.setText("Ninguno.");
                            
                            //LlenarServicios();
                            //LlenarProductos();
                            //LlenarBarberos();
                            SeleccionarServicio.setSelectedIndex(0);
                            SeleccionarProducto.setSelectedIndex(0);
                            SeleccionarBarbero.setSelectedIndex(0);
                        }else
                            if(SeleccionarServicio.getSelectedItem().toString().equals("...") && !SeleccionarProducto.getSelectedItem().toString().equals("...")){
                                AgregarVentaProducto(false);
                                Productos producto = (Productos) SeleccionarProducto.getSelectedItem();
                                float dos = producto.getPrecio();
                                Cambio(dos,0);
                                String productoHecho = producto.getProducto();
                                RespuestaServicioHecho.setText("Ninguno.");
                                RespuestaProductoHecho.setText("$"+dos+" "+productoHecho);
                                
                                //LlenarServicios();
                                //LlenarProductos();
                                //LlenarBarberos();
                                SeleccionarServicio.setSelectedIndex(0);
                                SeleccionarProducto.setSelectedIndex(0);
                                SeleccionarBarbero.setSelectedIndex(0);
                            }
    }//GEN-LAST:event_BotonConfirmarInsercionActionPerformed

    private void BotonServiciosDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonServiciosDiaActionPerformed
        BotonServiciosDia.setEnabled(false);
        BotonAgendaDeHoy.setEnabled(true);
        BotonInsertar.setEnabled(true);
        
        
                
        //ScrollAgendaServiciosDia.setVisible(true);
        SeleccionarMostrar.setVisible(true);
        BotonConfirmarMostrar.setVisible(true);
        
        SeleccionarServicio.setVisible(false);
        SeleccionarProducto.setVisible(false);
        SeleccionarBarbero.setVisible(false);
        BotonConfirmarInsercion.setVisible(false);
        TextoAddServicios.setVisible(false);
        TextoAddProductos.setVisible(false);
        TextoAddBarberos.setVisible(false);
        ScrollAgenda.setVisible(false);
        BotonAgendaModificar.setVisible(false);
        BotonAgendaLimpiar.setVisible(false);
        BotonAsistencia.setVisible(false);
        BotonDesasistencia.setVisible(false);
        BotonAgendaAgregar.setVisible(false);
        BotonAgendaActualizar.setVisible(false);
        TextoAgendaCliente.setVisible(false);
        TextoAgendaBarbero.setVisible(false);
        TextoAgendaId.setVisible(false);
        LeerAgendaCliente.setVisible(false);
        TextoHoraAgenda.setVisible(false);
        SeleccionarHoraAgenda.setVisible(false);
        TextoServicioAgenda.setVisible(false);
        SeleccionarServicioAgenda.setVisible(false);
        TextoAgendaFecha.setVisible(false);
        BotonOjo.setVisible(false);
        TextoCitas.setVisible(false);
        Hora1.setVisible(false);
        Hora2.setVisible(false);
        Hora3.setVisible(false);
        Hora4.setVisible(false);
        Hora5.setVisible(false);
        Hora6.setVisible(false);
        Hora7.setVisible(false);
        Hora8.setVisible(false);
        Hora9.setVisible(false);
        Hora10.setVisible(false);
        Hora11.setVisible(false);
        Hora12.setVisible(false);
        Hora13.setVisible(false);
        Hora14.setVisible(false);
        Hora15.setVisible(false);
        Hora16.setVisible(false);
        Hora17.setVisible(false);
        Hora18.setVisible(false);
        Hora19.setVisible(false);
        Hora20.setVisible(false);
        Hora21.setVisible(false);
        Hora22.setVisible(false);
        Hora23.setVisible(false);
        Hora24.setVisible(false);
        Hora25.setVisible(false);
        Hora26.setVisible(false);
        Hora27.setVisible(false);
        TextoServiciosDuracion.setVisible(false);
        ScrollServiciosDuracion.setVisible(false);
        RespuestaAgendaBarbero.setVisible(false);
        LeerAgendaFecha.setVisible(false);
        RespuestaAgendaId.setVisible(false);
        RespuestaAgendaIdBarbero.setVisible(false);
        SeleccionarAgendaBarbero.setVisible(false);
        BotonConfirmarAgenda.setVisible(false);
        ElegirAgendaFecha.setVisible(false);
        TextoCambioTotal.setVisible(false);
        RespuestaCambioTotal.setVisible(false);
        TextoPagoCon.setVisible(false);
        LeerPagoCon.setVisible(false);
        BotonCambio.setVisible(false);
        BotonOtraInsercion.setVisible(false);
        TextoCambio.setVisible(false);
        RespuestaCambio.setVisible(false);
        TextoServicioHecho.setVisible(false);
        RespuestaServicioHecho.setVisible(false);
        TextoProductoHecho.setVisible(false);
        RespuestaProductoHecho.setVisible(false);
    }//GEN-LAST:event_BotonServiciosDiaActionPerformed

    private void RespuestaAgendaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RespuestaAgendaIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RespuestaAgendaIdActionPerformed

    private void BotonAgendaActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgendaActualizarActionPerformed
        //Fecha Seleccionada
        Date fechaSeleccionada = ElegirAgendaFecha.getDate();
        String f2;
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
        f2 = formatoFecha2.format(fechaSeleccionada);   //Contiene la fecha Seleccionada
        
        Barberos barbero = (Barberos) SeleccionarAgendaBarbero.getSelectedItem();
        int idBarbero = barbero.getId();
        Servicios idServicio = (Servicios) SeleccionarServicioAgenda.getSelectedItem();
        String servicio = idServicio.getServicio();
        
        if(RespuestaAgendaBarbero.getText().equals("") && LeerAgendaCliente.getText().equals("") && RespuestaAgendaId.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Campos Vacios.");
        else
            if(LeerAgendaCliente.getText().equals(""))
                JOptionPane.showMessageDialog(null,"Ingrese Un Cliente.");
            else
                if(SeleccionarHoraAgenda.getSelectedItem().toString().equals("..."))
                    JOptionPane.showMessageDialog(null,"Seleccione Una Hora.");
                else
                    if(RespuestaAgendaId.getText().equals(""))
                        JOptionPane.showMessageDialog(null,"Agenda Inexistente.");
                    else
                        if(servicio.equals("..."))
                            JOptionPane.showMessageDialog(null,"Barbero Inexistente.");
                        else{
                            if(JOptionPane.showInternalConfirmDialog(null, "¿Confirmar Actualizacion?") == 0){
                                ActualizarAgenda();
                                LimpiarAgendaField();
                                ConsultarAgenda(f2,idBarbero);
                                
                                //27 Banderas para las horas (cada media hora)
                                tiempo1 = false;
                                tiempo2 = false;
                                tiempo3 = false;
                                tiempo4 = false;
                                tiempo5 = false;
                                tiempo6 = false;
                                tiempo7 = false;
                                tiempo8 = false;
                                tiempo9 = false;
                                tiempo10 = false;
                                tiempo11 = false;
                                tiempo12 = false;
                                tiempo13 = false;
                                tiempo14 = false;
                                tiempo15 = false;
                                tiempo16 = false;
                                tiempo17 = false;
                                tiempo18 = false;
                                tiempo19 = false;
                                tiempo20 = false;
                                tiempo21 = false;
                                tiempo22 = false;
                                tiempo23 = false;
                                tiempo24 = false;
                                tiempo25 = false;
                                tiempo26 = false;
                                tiempo27 = false;
                                LlenarHorarios(f2,idBarbero);
                            }
                        }
    }//GEN-LAST:event_BotonAgendaActualizarActionPerformed

    private void BotonAgendaLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgendaLimpiarActionPerformed
        LimpiarAgendaField();
    }//GEN-LAST:event_BotonAgendaLimpiarActionPerformed

    private void BotonAgendaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgendaModificarActionPerformed
        int fila = TablaAgenda.getSelectedRow();
        if(fila >= 0){
            //RespuestaAgendaId.setEnabled(false);
            RespuestaAgendaId.setText(TablaAgenda.getValueAt(fila, 0).toString());
            LeerAgendaCliente.setText(TablaAgenda.getValueAt(fila, 1).toString());
            RespuestaAgendaIdBarbero.setText(TablaAgenda.getValueAt(fila, 2).toString());
            RespuestaAgendaBarbero.setText(TablaAgenda.getValueAt(fila, 3).toString());
            SeleccionarHoraAgenda.setSelectedItem(TablaAgenda.getValueAt(fila, 8).toString());
            
            String idServicio1 = TablaAgenda.getValueAt(fila, 4).toString();
            int idServicio = Integer.parseInt(idServicio1);
            int cont = 0;
            nListaServicios = ConsultarServicios();
            Iterator iterador = nListaServicios.iterator();
            while(iterador.hasNext()){
                Servicios nServicio = (Servicios) iterador.next();
                if(nServicio.getId() == idServicio)
                   SeleccionarServicioAgenda.setSelectedIndex(cont);
                cont+=1;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione Una Fila De La Tabla.");
        }
    }//GEN-LAST:event_BotonAgendaModificarActionPerformed

    private void BotonAgendaAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgendaAgregarActionPerformed
        //Fecha Seleccionada
        Date fechaSeleccionada = ElegirAgendaFecha.getDate();
        String f2;
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
        f2 = formatoFecha2.format(fechaSeleccionada);   //Contiene la fecha Seleccionada
        
        Barberos barbero = (Barberos) SeleccionarAgendaBarbero.getSelectedItem();
        int idBarbero = barbero.getId();
        Servicios idServicio = (Servicios) SeleccionarServicioAgenda.getSelectedItem();
        String servicio = idServicio.getServicio();
        
        if(LeerAgendaCliente.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Un Cliente.");
        else
            if(SeleccionarHoraAgenda.getSelectedItem().toString().equals("..."))
                JOptionPane.showMessageDialog(null, "Seleccione Una Hora.");
            else
                if(servicio.equals("..."))
                    JOptionPane.showMessageDialog(null, "Seleccione Un Servicio");
                else
                    if(JOptionPane.showInternalConfirmDialog(null, "¿Confirmar Cita A La Agenda De:"+RespuestaAgendaBarbero.getText()+".") == 0){
                        AgregarAgenda();
                        LimpiarAgendaField();
                        ConsultarAgenda(f2,idBarbero);
                        
                        //27 Banderas para las horas (cada media hora)
                        tiempo1 = false;
                        tiempo2 = false;
                        tiempo3 = false;
                        tiempo4 = false;
                        tiempo5 = false;
                        tiempo6 = false;
                        tiempo7 = false;
                        tiempo8 = false;
                        tiempo9 = false;
                        tiempo10 = false;
                        tiempo11 = false;
                        tiempo12 = false;
                        tiempo13 = false;
                        tiempo14 = false;
                        tiempo15 = false;
                        tiempo16 = false;
                        tiempo17 = false;
                        tiempo18 = false;
                        tiempo19 = false;
                        tiempo20 = false;
                        tiempo21 = false;
                        tiempo22 = false;
                        tiempo23 = false;
                        tiempo24 = false;
                        tiempo25 = false;
                        tiempo26 = false;
                        tiempo27 = false;
                        LlenarHorarios(f2,idBarbero);
                    }
    }//GEN-LAST:event_BotonAgendaAgregarActionPerformed

    private void RespuestaAgendaIdBarberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RespuestaAgendaIdBarberoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RespuestaAgendaIdBarberoActionPerformed

    private void RespuestaAgendaBarberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RespuestaAgendaBarberoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RespuestaAgendaBarberoActionPerformed

    private void BotonAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAsistenciaActionPerformed
        //Fecha Seleccionada
        Date fechaSeleccionada = ElegirAgendaFecha.getDate();
        String f2;
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
        f2 = formatoFecha2.format(fechaSeleccionada);   //Contiene la fecha Seleccionada
        
        Barberos barbero = (Barberos) SeleccionarAgendaBarbero.getSelectedItem();
        int idBarbero = barbero.getId();
        
        if(RespuestaAgendaBarbero.getText().equals("") && LeerAgendaCliente.getText().equals("") && RespuestaAgendaId.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Campos Vacios.");
        else
            if(LeerAgendaCliente.getText().equals(""))
                JOptionPane.showMessageDialog(null,"Campo: Cliente Vacio.");
            else
                if(RespuestaAgendaBarbero.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Campo: Barbero Vacio.");
                else
                    if(RespuestaAgendaId.getText().equals(""))
                        JOptionPane.showMessageDialog(null,"Cita Inexistente.");
                    else
                        if(RespuestaAgendaIdBarbero.getText().equals(""))
                            JOptionPane.showMessageDialog(null,"Barbero Inexistente.");
                        else{
                            if(JOptionPane.showInternalConfirmDialog(null, "¿Confirmar ASISTENCIA del cliente:"+LeerAgendaCliente.getText()+" en la agenda de:"+RespuestaAgendaBarbero.getText()+"?") == 0){
                                ConfirmarAsistencia();
                                LimpiarAgendaField();
                                ConsultarAgenda(f2,idBarbero);
                            }
                        }
    }//GEN-LAST:event_BotonAsistenciaActionPerformed

    private void BotonDesasistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDesasistenciaActionPerformed
        //Fecha Seleccionada
        Date fechaSeleccionada = ElegirAgendaFecha.getDate();
        String f2;
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
        f2 = formatoFecha2.format(fechaSeleccionada);   //Contiene la fecha Seleccionada
        
        Barberos barbero = (Barberos) SeleccionarAgendaBarbero.getSelectedItem();
        int idBarbero = barbero.getId();
        
        if(RespuestaAgendaBarbero.getText().equals("") && LeerAgendaCliente.getText().equals("") && RespuestaAgendaId.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Campos Vacios.");
        else
            if(LeerAgendaCliente.getText().equals(""))
                JOptionPane.showMessageDialog(null,"Campo: Cliente Vacio.");
            else
                if(RespuestaAgendaBarbero.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Campo: Barbero Vacio.");
                else
                    if(RespuestaAgendaId.getText().equals(""))
                        JOptionPane.showMessageDialog(null,"Cita Inexistente.");
                    else
                        if(RespuestaAgendaIdBarbero.getText().equals(""))
                            JOptionPane.showMessageDialog(null,"Barbero Inexistente.");
                        else{
                            if(JOptionPane.showInternalConfirmDialog(null, "¿Confirmar DESASISTENCIA del cliente:"+LeerAgendaCliente.getText()+" en la agenda de:"+RespuestaAgendaBarbero.getText()+"?") == 0){
                                NoConfirmarAsistencia();
                                LimpiarAgendaField();
                                ConsultarAgenda(f2,idBarbero);
                            }
                        }
    }//GEN-LAST:event_BotonDesasistenciaActionPerformed

    private void BotonConfirmarMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmarMostrarActionPerformed
        ScrollServiciosDia.setVisible(false);
        ScrollProductosDia.setVisible(false);
        if(SeleccionarMostrar.getSelectedItem().toString().equals("..."))
            JOptionPane.showMessageDialog(null,"Seleccione una opcion.");
        else{
            String sql;
            //Fecha De Hoy
            Date fechaActual = new Date();
            String f;
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            f = formatoFecha.format(fechaActual);   //Contiene la fecha de hoy
            
            if(SeleccionarMostrar.getSelectedItem().toString().equals("Servicios")){
                ScrollServiciosDia.setVisible(true);
                sql = "SELECT servicios.precio AS Precio, servicios.servicio AS Servicio, barberos.nombre_usuario AS Barbero, ventasservicios.fecha AS Fecha, ventasservicios.hora AS Hora "
                        + "FROM barberos, servicios, ventasservicios "
                        + "WHERE ventasservicios.id_servicio = servicios.id_servicio AND ventasservicios.id_barbero = barberos.id_barbero AND Fecha = '"+f+"' "
                        + "ORDER BY ventasservicios.hora ASC";
                ConsultarServiciosDia(sql);
            }else
                if(SeleccionarMostrar.getSelectedItem().toString().equals("Productos")){
                    ScrollProductosDia.setVisible(true);
                    sql = "SELECT productos.precio AS Precio, productos.producto AS Producto, barberos.nombre_usuario AS Barbero, ventasproductos.fecha AS Fecha, ventasproductos.hora AS Hora "
                                     + "FROM barberos, productos, ventasproductos "
                                     + "WHERE ventasproductos.id_producto = productos.id_producto AND ventasproductos.id_barbero = barberos.id_barbero AND Fecha = '"+f+"' "
                                     + "ORDER BY ventasproductos.hora ASC";
                    ConsultarProductosDia(sql);
                }
        }
    }//GEN-LAST:event_BotonConfirmarMostrarActionPerformed

    private void LeerPagoConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeerPagoConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LeerPagoConActionPerformed

    private void BotonCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCambioActionPerformed
        if(LeerPagoCon.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese el monto.");
        }else{
            float pago = (float) Float.parseFloat(LeerPagoCon.getText());
            float total = Float.parseFloat(RespuestaCambioTotal.getText());
            
            if(pago >= total){
                float cambio = pago-total;
                TextoCambio.setVisible(true);
                RespuestaCambio.setVisible(true);
                RespuestaCambio.setText(""+cambio);
            }else
                JOptionPane.showMessageDialog(null, "Ingrese un monto mayor al monto total.");
        }
    }//GEN-LAST:event_BotonCambioActionPerformed

    private void BotonOtraInsercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOtraInsercionActionPerformed
        TextoCambioTotal.setVisible(false);
        RespuestaCambioTotal.setVisible(false);
        TextoPagoCon.setVisible(false);
        LeerPagoCon.setVisible(false);
        BotonCambio.setVisible(false);
        BotonOtraInsercion.setVisible(false);
        TextoCambio.setVisible(false);
        RespuestaCambio.setVisible(false);
        TextoServicioHecho.setVisible(false);
        RespuestaServicioHecho.setVisible(false);
        TextoProductoHecho.setVisible(false);
        RespuestaProductoHecho.setVisible(false);
        
        LeerPagoCon.setText("");
        RespuestaCambio.setText("");
        
        SeleccionarServicio.setVisible(true);
        SeleccionarProducto.setVisible(true);
        SeleccionarBarbero.setVisible(true);
        BotonConfirmarInsercion.setVisible(true);
        TextoAddServicios.setVisible(true);
        TextoAddProductos.setVisible(true);
        TextoAddBarberos.setVisible(true);
    }//GEN-LAST:event_BotonOtraInsercionActionPerformed

    private void SeleccionarMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarMostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarMostrarActionPerformed

    private void BotonConfirmarAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmarAgendaActionPerformed
        ScrollAgenda.setVisible(false);
        BotonAgendaModificar.setVisible(false);
        BotonAgendaLimpiar.setVisible(false);
        BotonAsistencia.setVisible(false);
        BotonDesasistencia.setVisible(false);
        BotonAgendaAgregar.setVisible(false);
        BotonAgendaActualizar.setVisible(false);
        TextoAgendaCliente.setVisible(false);
        TextoAgendaBarbero.setVisible(false);
        TextoAgendaId.setVisible(false);
        LeerAgendaCliente.setVisible(false);
        TextoHoraAgenda.setVisible(false);
        SeleccionarHoraAgenda.setVisible(false);
        TextoServicioAgenda.setVisible(false);
        SeleccionarServicioAgenda.setVisible(false);
        TextoAgendaFecha.setVisible(false);
        BotonOjo.setVisible(false);
        TextoCitas.setVisible(false);
        Hora1.setVisible(false);
        Hora2.setVisible(false);
        Hora3.setVisible(false);
        Hora4.setVisible(false);
        Hora5.setVisible(false);
        Hora6.setVisible(false);
        Hora7.setVisible(false);
        Hora8.setVisible(false);
        Hora9.setVisible(false);
        Hora10.setVisible(false);
        Hora11.setVisible(false);
        Hora12.setVisible(false);
        Hora13.setVisible(false);
        Hora14.setVisible(false);
        Hora15.setVisible(false);
        Hora16.setVisible(false);
        Hora17.setVisible(false);
        Hora18.setVisible(false);
        Hora19.setVisible(false);
        Hora20.setVisible(false);
        Hora21.setVisible(false);
        Hora22.setVisible(false);
        Hora23.setVisible(false);
        Hora24.setVisible(false);
        Hora25.setVisible(false);
        Hora26.setVisible(false);
        Hora27.setVisible(false);
        TextoServiciosDuracion.setVisible(false);
        ScrollServiciosDuracion.setVisible(false);
        RespuestaAgendaBarbero.setVisible(false);
        LeerAgendaFecha.setVisible(false);
        RespuestaAgendaId.setVisible(false);
        RespuestaAgendaIdBarbero.setVisible(false);
        //ElegirAgendaFecha.setVisible(false);
        if(SeleccionarAgendaBarbero.getSelectedItem().toString().equals("..."))
            JOptionPane.showMessageDialog(null,"Seleccione un BARBERO.");
        else
            if(ElegirAgendaFecha.getDate() == null)
                JOptionPane.showMessageDialog(null,"Seleccione una FECHA.");
            else{
                Barberos barbero = (Barberos) SeleccionarAgendaBarbero.getSelectedItem();
                String nombreBarbero = barbero.getBarbero();
                int idBarbero = barbero.getId();
                
                //Fecha Seleccionada
                Date fechaSeleccionada = ElegirAgendaFecha.getDate();
                String f2,f3;
                SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
                //SimpleDateFormat formatoFecha3 = new SimpleDateFormat("dd-MM-yyyy");
                f2 = formatoFecha2.format(fechaSeleccionada);   //Contiene la fecha Seleccionada
                //f3 = formatoFecha3.format(fechaSeleccionada);
                ConsultarAgenda(f2,idBarbero);

                ScrollAgenda.setVisible(true);
                BotonAgendaModificar.setVisible(true);
                BotonAgendaLimpiar.setVisible(true);
                BotonAsistencia.setVisible(true);
                BotonDesasistencia.setVisible(true);
                BotonAgendaAgregar.setVisible(true);
                BotonAgendaActualizar.setVisible(true);
                TextoAgendaCliente.setVisible(true);
                TextoAgendaBarbero.setVisible(true);
                TextoAgendaId.setVisible(true);
                LeerAgendaCliente.setVisible(true);
                TextoHoraAgenda.setVisible(true);
                SeleccionarHoraAgenda.setVisible(true);
                TextoServicioAgenda.setVisible(true);
                SeleccionarServicioAgenda.setVisible(true);
                TextoAgendaFecha.setVisible(true);
                BotonOjo.setVisible(true);
                RespuestaAgendaBarbero.setVisible(true);
                RespuestaAgendaBarbero.setEnabled(false);
                RespuestaAgendaBarbero.setText(nombreBarbero);
                LeerAgendaFecha.setVisible(true);
                LeerAgendaFecha.setEnabled(false);
                LeerAgendaFecha.setText(f2);
                RespuestaAgendaId.setVisible(true);
                RespuestaAgendaId.setEnabled(false);
                RespuestaAgendaIdBarbero.setVisible(true);
                RespuestaAgendaIdBarbero.setEnabled(false);
                RespuestaAgendaIdBarbero.setText(""+idBarbero);
                ElegirAgendaFecha.setVisible(true);
                
                //27 Banderas para las horas (cada media hora)
                tiempo1 = false;
                tiempo2 = false;
                tiempo3 = false;
                tiempo4 = false;
                tiempo5 = false;
                tiempo6 = false;
                tiempo7 = false;
                tiempo8 = false;
                tiempo9 = false;
                tiempo10 = false;
                tiempo11 = false;
                tiempo12 = false;
                tiempo13 = false;
                tiempo14 = false;
                tiempo15 = false;
                tiempo16 = false;
                tiempo17 = false;
                tiempo18 = false;
                tiempo19 = false;
                tiempo20 = false;
                tiempo21 = false;
                tiempo22 = false;
                tiempo23 = false;
                tiempo24 = false;
                tiempo25 = false;
                tiempo26 = false;
                tiempo27 = false;
                LlenarHorarios(f2,idBarbero);
            }
    }//GEN-LAST:event_BotonConfirmarAgendaActionPerformed

    private void SeleccionarAgendaBarberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarAgendaBarberoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarAgendaBarberoActionPerformed

    private void BotonOjoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOjoActionPerformed
        ScrollAgenda.setVisible(true);
        BotonAgendaModificar.setVisible(true);
        TextoAgendaCliente.setVisible(true);
        LeerAgendaCliente.setVisible(true);
        TextoHoraAgenda.setVisible(true);
        SeleccionarHoraAgenda.setVisible(true);
        TextoServicioAgenda.setVisible(true);
        SeleccionarServicioAgenda.setVisible(true);
        TextoAgendaFecha.setVisible(true);
        LeerAgendaFecha.setVisible(true);
        TextoAgendaBarbero.setVisible(true);
        RespuestaAgendaBarbero.setVisible(true);
        RespuestaAgendaIdBarbero.setVisible(true);
        TextoAgendaId.setVisible(true);
        RespuestaAgendaId.setVisible(true);
        BotonAsistencia.setVisible(true);
        BotonDesasistencia.setVisible(true);
        BotonAgendaLimpiar.setVisible(true);
        BotonAgendaAgregar.setVisible(true);
        BotonAgendaActualizar.setVisible(true);
        
        TextoCitas.setVisible(false);
        Hora1.setVisible(false);
        Hora2.setVisible(false);
        Hora3.setVisible(false);
        Hora4.setVisible(false);
        Hora5.setVisible(false);
        Hora6.setVisible(false);
        Hora7.setVisible(false);
        Hora8.setVisible(false);
        Hora9.setVisible(false);
        Hora10.setVisible(false);
        Hora11.setVisible(false);
        Hora12.setVisible(false);
        Hora13.setVisible(false);
        Hora14.setVisible(false);
        Hora15.setVisible(false);
        Hora16.setVisible(false);
        Hora17.setVisible(false);
        Hora18.setVisible(false);
        Hora19.setVisible(false);
        Hora20.setVisible(false);
        Hora21.setVisible(false);
        Hora22.setVisible(false);
        Hora23.setVisible(false);
        Hora24.setVisible(false);
        Hora25.setVisible(false);
        Hora26.setVisible(false);
        Hora27.setVisible(false);
        TextoServiciosDuracion.setVisible(false);
        ScrollServiciosDuracion.setVisible(false);
        if(BotonOjo.isSelected()){
            ScrollAgenda.setVisible(false);
            BotonAgendaModificar.setVisible(false);
            TextoAgendaCliente.setVisible(false);
            LeerAgendaCliente.setVisible(false);
            TextoHoraAgenda.setVisible(false);
            SeleccionarHoraAgenda.setVisible(false);
            TextoServicioAgenda.setVisible(false);
            SeleccionarServicioAgenda.setVisible(false);
            TextoAgendaFecha.setVisible(false);
            LeerAgendaFecha.setVisible(false);
            TextoAgendaBarbero.setVisible(false);
            RespuestaAgendaBarbero.setVisible(false);
            RespuestaAgendaIdBarbero.setVisible(false);
            TextoAgendaId.setVisible(false);
            RespuestaAgendaId.setVisible(false);
            BotonAsistencia.setVisible(false);
            BotonDesasistencia.setVisible(false);
            BotonAgendaLimpiar.setVisible(false);
            BotonAgendaAgregar.setVisible(false);
            BotonAgendaActualizar.setVisible(false);
            
            TextoCitas.setVisible(true);
            Hora1.setVisible(true);
            Hora2.setVisible(true);
            Hora3.setVisible(true);
            Hora4.setVisible(true);
            Hora5.setVisible(true);
            Hora6.setVisible(true);
            Hora7.setVisible(true);
            Hora8.setVisible(true);
            Hora9.setVisible(true);
            Hora10.setVisible(true);
            Hora11.setVisible(true);
            Hora12.setVisible(true);
            Hora13.setVisible(true);
            Hora14.setVisible(true);
            Hora15.setVisible(true);
            Hora16.setVisible(true);
            Hora17.setVisible(true);
            Hora18.setVisible(true);
            Hora19.setVisible(true);
            Hora20.setVisible(true);
            Hora21.setVisible(true);
            Hora22.setVisible(true);
            Hora23.setVisible(true);
            Hora24.setVisible(true);
            Hora25.setVisible(true);
            Hora26.setVisible(true);
            Hora27.setVisible(true);
            TextoServiciosDuracion.setVisible(true);
            ScrollServiciosDuracion.setVisible(true);

            Barberos barbero = (Barberos) SeleccionarAgendaBarbero.getSelectedItem();
            String nombreBarbero = barbero.getBarbero();
            int idBarbero = barbero.getId();
            
            //Fecha Seleccionada
            Date fechaSeleccionada = ElegirAgendaFecha.getDate();
            String f2;
            SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
            f2 = formatoFecha2.format(fechaSeleccionada);   //Contiene la fecha Seleccionada
                
            //27 Banderas para las horas (cada media hora)
            tiempo1 = false;
            tiempo2 = false;
            tiempo3 = false;
            tiempo4 = false;
            tiempo5 = false;
            tiempo6 = false;
            tiempo7 = false;
            tiempo8 = false;
            tiempo9 = false;
            tiempo10 = false;
            tiempo11 = false;
            tiempo12 = false;
            tiempo13 = false;
            tiempo14 = false;
            tiempo15 = false;
            tiempo16 = false;
            tiempo17 = false;
            tiempo18 = false;
            tiempo19 = false;
            tiempo20 = false;
            tiempo21 = false;
            tiempo22 = false;
            tiempo23 = false;
            tiempo24 = false;
            tiempo25 = false;
            tiempo26 = false;
            tiempo27 = false;
            
            VisualizarCitas(f2,idBarbero);
            VisualizarServiciosDuracion();
        }
    }//GEN-LAST:event_BotonOjoActionPerformed

    private void SeleccionarHoraAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarHoraAgendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeleccionarHoraAgendaActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazSecre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazSecre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazSecre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazSecre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazSecre().setVisible(true);
            }
        });
    }
    
    private void restringeNumeros(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }
    
    private void restringeChars(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isLetter(c) && !Character.isSpaceChar(c)){
                    e.consume();
                }
            }
        });
    }
    
    //------------------------------------------------CombosBox (Insertar Servicios)--------------------------------------------------------
    
    ArrayList ConsultarServicios(){
        ArrayList nListaServicios = new ArrayList();
        Servicios nServicios = null;
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM servicios";
        try {
            st = conexion.cx.createStatement();
            rs = st.executeQuery(sql);
            
            //rs.next();
            while(rs.next()){
                nServicios = new Servicios();
                nServicios.setId(rs.getInt("id_servicio"));
                nServicios.setServicio(rs.getString("servicio"));
                nServicios.setPrecio(rs.getFloat("precio"));
                nServicios.setDuracion(rs.getString("duracion"));
                nServicios.setDur(rs.getInt("dur"));
                nListaServicios.add(nServicios);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazSecre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nListaServicios;
    }
    
    void LlenarServicios(){
        SeleccionarServicio.removeAllItems();
        nListaServicios = ConsultarServicios();
        Iterator iterador = nListaServicios.iterator();
        //SeleccionarServicio.addItem("");
        while(iterador.hasNext()){
            Servicios nServicio = (Servicios) iterador.next();
            SeleccionarServicioAgenda.addItem(nServicio);
            SeleccionarServicio.addItem(nServicio);
        }
    }
    
    ArrayList ConsultarProductos(){
        ArrayList nListaProductos = new ArrayList();
        Productos nProductos = null;
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM productos";
        try {
            st = conexion.cx.createStatement();
            rs = st.executeQuery(sql);
            
            //rs.next();
            while(rs.next()){
                nProductos = new Productos();
                nProductos.setId(rs.getInt("id_producto"));
                nProductos.setProducto(rs.getString("producto"));
                nProductos.setPrecio(rs.getFloat("precio"));
                nListaProductos.add(nProductos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazSecre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nListaProductos;
    }
    
    void LlenarProductos(){
        SeleccionarProducto.removeAllItems();
        nListaProductos = ConsultarProductos();
        Iterator iterador = nListaProductos.iterator();
        //SeleccionarProducto.addItem("");
        while(iterador.hasNext()){
            Productos nProducto = (Productos) iterador.next();
            SeleccionarProducto.addItem(nProducto);
        }
    }
    
    ArrayList ConsultarBarberos(){
        ArrayList nListaBarberos = new ArrayList();
        Barberos nBarberos = null;
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM barberos";
        try {
            st = conexion.cx.createStatement();
            rs = st.executeQuery(sql);
            
            //rs.next();
            while(rs.next()){
                nBarberos = new Barberos();
                nBarberos.setId(rs.getInt("id_barbero"));
                nBarberos.setBarbero(rs.getString("nombre_usuario"));
                nBarberos.setTipo(rs.getString("tipo_u"));
                if(!nBarberos.getTipo().equals("Administrador"))
                    nListaBarberos.add(nBarberos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazSecre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nListaBarberos;
    }
    
    void LlenarBarberos(){
        SeleccionarBarbero.removeAllItems();
        nListaBarberos = ConsultarBarberos();
        Iterator iterador = nListaBarberos.iterator();
        //SeleccionarBarbero.addItem("");
        while(iterador.hasNext()){
            Barberos nBarbero = (Barberos) iterador.next();
            SeleccionarAgendaBarbero.addItem(nBarbero);
            SeleccionarBarbero.addItem(nBarbero);
        }
    }
    
    void AgregarVentaServicio(boolean banderita){
        Servicios idServicio = (Servicios) SeleccionarServicio.getSelectedItem();
        Barberos idBarbero = (Barberos) SeleccionarBarbero.getSelectedItem();
        
        Date fechaActual = new Date();
        String f;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        f = formatoFecha.format(fechaActual);   //Contiene la fecha de hoy
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String hora = dateFormat.format(new Date());
        //System.out.println(hora);
        
        Float precio_eventual;
        try{    
            Statement st = conexion.cx.createStatement();
            ResultSet rs;
            String sql2 = "SELECT servicios.precio AS Precio_Eventual FROM servicios WHERE servicios.id_servicio = "+idServicio.getId()+" ";
            rs = st.executeQuery(sql2);
            rs.next();
            precio_eventual = rs.getFloat("Precio_Eventual");
                
            String sql = "INSERT INTO ventasservicios(id_servicio,id_barbero,fecha,hora,precio_eventual) VALUES(?,?,?,?,?)";
            PreparedStatement pps = conexion.cx.prepareStatement(sql);
               
            pps.setInt(1,idServicio.getId());
            pps.setInt(2, idBarbero.getId());
            pps.setString(3,f);
            pps.setString(4, hora);
            pps.setFloat(5,precio_eventual);
            pps.executeUpdate();
                
            if(banderita == true)
                JOptionPane.showMessageDialog(null,"Servicio Y Producto Agregado.");
            else
                JOptionPane.showMessageDialog(null,"Servicio Agregado.");
        }catch (SQLException ex){
            Logger.getLogger(InterfazRegistrarse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void AgregarVentaProducto(boolean banderita){
        Productos idProducto = (Productos) SeleccionarProducto.getSelectedItem();
        Barberos idBarbero = (Barberos) SeleccionarBarbero.getSelectedItem();
        
        Date fechaActual = new Date();
        String f;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        f = formatoFecha.format(fechaActual);   //Contiene la fecha de hoy
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String hora = dateFormat.format(new Date());
        //System.out.println(hora);
        
        Float precio_eventual;
        try{    
            Statement st = conexion.cx.createStatement();
            ResultSet rs;
            String sql2 = "SELECT productos.precio AS Precio_Eventual FROM productos WHERE productos.id_producto = "+idProducto.getId()+" ";
            rs = st.executeQuery(sql2);
            rs.next();
            precio_eventual = rs.getFloat("Precio_Eventual");
                
            String sql = "INSERT INTO ventasproductos(id_producto,id_barbero,fecha,hora,precio_eventual) VALUES(?,?,?,?,?)";
            PreparedStatement pps = conexion.cx.prepareStatement(sql);
                
            pps.setInt(1,idProducto.getId());
            pps.setInt(2, idBarbero.getId());
            pps.setString(3,f);
            pps.setString(4, hora);
            pps.setFloat(5, precio_eventual);
            pps.executeUpdate();
            if(banderita == false)
                JOptionPane.showMessageDialog(null,"Producto Agregado.");
        }catch (SQLException ex){
            Logger.getLogger(InterfazRegistrarse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Cambio(float uno, float dos){
        TextoCambioTotal.setVisible(true);
        RespuestaCambioTotal.setVisible(true);
        TextoPagoCon.setVisible(true);
        LeerPagoCon.setVisible(true);
        BotonCambio.setVisible(true);
        BotonOtraInsercion.setVisible(true);
        TextoServicioHecho.setVisible(true);
        RespuestaServicioHecho.setVisible(true);
        TextoProductoHecho.setVisible(true);
        RespuestaProductoHecho.setVisible(true);
        
        float total = uno+dos;
        String total2;
        total2 = String.valueOf(total);
        RespuestaCambioTotal.setText(total2);
        
        SeleccionarServicio.setVisible(false);
        SeleccionarProducto.setVisible(false);
        SeleccionarBarbero.setVisible(false);
        BotonConfirmarInsercion.setVisible(false);
        TextoAddServicios.setVisible(false);
        TextoAddProductos.setVisible(false);
        TextoAddBarberos.setVisible(false);
    }
    
    //------------------------------------------------Agenda--------------------------------------------------------------
    
    void ConsultarAgenda(String f,int idBarbero){
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 10;
            }
        };
                
        modelo.addColumn("Id");
        modelo.addColumn("Cliente");
        modelo.addColumn("Id_Barbero");
        modelo.addColumn("Barbero");
        modelo.addColumn("Id_Servicio");
        modelo.addColumn("Servicio");
        modelo.addColumn("Confirmo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Duracion");
        TablaAgenda.setModel(modelo);
        
        String sql = "SELECT agenda.id_agenda, agenda.nombre_cliente, agenda.id_barbero, barberos.nombre_usuario, servicios.id_servicio, servicios.servicio, agenda.confirmar, agenda.fecha, agenda.hora, servicios.duracion "
                + "FROM agenda, barberos, servicios "
                + "WHERE agenda.id_barbero = barberos.id_barbero AND agenda.fecha = '"+f+"' AND barberos.id_barbero = "+idBarbero+" AND agenda.id_servicio = servicios.id_servicio "
                + "ORDER BY agenda.hora ASC";
                
        //System.out.println(sql);
        Object[] cliente = new Object [10];
        
        try{
            Statement st;
            ResultSet rs;

            st = conexion.cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                cliente [0] = rs.getString(1);
                cliente [1] = rs.getString(2);
                cliente [2] = rs.getString(3);
                cliente [3] = rs.getString(4);
                cliente [4] = rs.getString(5);
                cliente [5] = rs.getString(6);
                cliente [6] = rs.getString(7);
                cliente [7] = rs.getString(8);
                cliente [8] = rs.getString(9);     
                cliente [9] = rs.getString(10);
                modelo.addRow(cliente);
            }            
            TablaAgenda.setModel(modelo);
        }catch(SQLException e){
            
        }
        TablaAgenda.getColumnModel().getColumn(0).setResizable(false);
        TablaAgenda.getColumnModel().getColumn(0).setMaxWidth(1);
        TablaAgenda.getColumnModel().getColumn(2).setResizable(false);
        TablaAgenda.getColumnModel().getColumn(2).setMaxWidth(1);
        TablaAgenda.getColumnModel().getColumn(4).setResizable(false);
        TablaAgenda.getColumnModel().getColumn(4).setMaxWidth(1);
        //TablaAgenda.getColumnModel().getColumn(6).setResizable(false);
        TablaAgenda.getColumnModel().getColumn(6).setPreferredWidth(2);
        TablaAgenda.getColumnModel().getColumn(8).setPreferredWidth(3);
        TablaAgenda.getColumnModel().getColumn(9).setPreferredWidth(3);
    }
    
    void LimpiarAgendaField(){
        LeerAgendaCliente.setText("");
        RespuestaAgendaId.setText("");
        SeleccionarHoraAgenda.setSelectedItem("...");
        
        SeleccionarServicioAgenda.setSelectedIndex(0);
    }
    
    void AgregarAgenda(){
        String cliente = LeerAgendaCliente.getText();
        int idbarbero;
        
        Date fechaActual = new Date();
        String f;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        f = formatoFecha.format(fechaActual);   //Contiene la fecha de hoy
        
        String hora = SeleccionarHoraAgenda.getSelectedItem().toString();
        //System.out.println(hora);
        
        Date fechaSeleccionada = ElegirAgendaFecha.getDate();
        //ElegirAgendaFecha.setDate(null);
        String f2;
        SimpleDateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
        f2 = formatoFecha2.format(fechaSeleccionada);   //Contiene la fecha Seleccionada
        
        Servicios idServicio = (Servicios) SeleccionarServicioAgenda.getSelectedItem();
        //int contador = idServicio.getDur();
        //ActivarBanderas(contador, hora);
        
        if(f2.compareTo(f) < 0)
            JOptionPane.showMessageDialog(null,"No Se Pueden Agendar Citas Para Dias Pasados");
        else{
            try{    
                Statement st;
                ResultSet rs;

                idbarbero = parseInt(RespuestaAgendaIdBarbero.getText());
                boolean bandera = false;//Para verificar que los datos no sean repetidos
                st = conexion.cx.createStatement();
                rs = st.executeQuery("Select * From agenda WHERE agenda.fecha = '"+f2+"'");
                Collator comparador = Collator.getInstance();
                comparador.setStrength(Collator.PRIMARY);
                String aux;
                while (rs.next() && bandera == false){
                    aux = rs.getString("nombre_cliente");
                    if(comparador.equals(aux, cliente)){
                        bandera = true;
                        JOptionPane.showMessageDialog(null,"Cliente: "+cliente+" Ya Agendando Para "+f2+".");
                    }
                }
                if(bandera == false){//Para ingresar la nueva agendada
                    PreparedStatement pps = conexion.cx.prepareStatement("INSERT INTO agenda(nombre_cliente,id_barbero,id_servicio,confirmar,fecha,hora) VALUES(?,?,?,?,?,?)");
                    pps.setString(1,cliente);
                    pps.setInt(2, idbarbero);
                    pps.setInt(3, idServicio.getId());
                    pps.setString(4,"no");        //No confirmado
                    pps.setString(5, f2);
                    pps.setString(6,hora);
                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Cliente:"+cliente+" Agendado.");
                }                
            }catch (SQLException ex){
                Logger.getLogger(InterfazRegistrarse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void ActualizarAgenda(){
        Servicios idServicio = (Servicios) SeleccionarServicioAgenda.getSelectedItem();
        
        String sql = "UPDATE agenda SET nombre_cliente = '"+LeerAgendaCliente.getText()+"', id_barbero = "+RespuestaAgendaIdBarbero.getText()+", id_servicio = "+idServicio.getId()+", hora = '"+SeleccionarHoraAgenda.getSelectedItem().toString()+"' WHERE id_agenda = "+RespuestaAgendaId.getText()+"";
        try {
            PreparedStatement pps = conexion.cx.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Agenda De:"+RespuestaAgendaBarbero.getText()+" Actualizada.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al Actualizar La Agenda De:"+RespuestaAgendaBarbero.getText()+".");
            Logger.getLogger(InterfazAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void ConfirmarAsistencia(){
        String si = "si";
        String sql = "UPDATE agenda SET confirmar = '"+si+"' WHERE id_agenda = "+RespuestaAgendaId.getText()+"";
        try {
            PreparedStatement pps = conexion.cx.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Agenda De:"+RespuestaAgendaBarbero.getText()+" Confirmada.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al Confirmar La Agenda De:"+RespuestaAgendaBarbero.getText()+".");
            Logger.getLogger(InterfazAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void NoConfirmarAsistencia(){
        String no = "no";
        String sql = "UPDATE agenda SET confirmar = '"+no+"' WHERE id_agenda = "+RespuestaAgendaId.getText()+"";
        try {
            PreparedStatement pps = conexion.cx.prepareStatement(sql);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Agenda De:"+RespuestaAgendaBarbero.getText()+" Confirmada.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Al Confirmar La Agenda De:"+RespuestaAgendaBarbero.getText()+".");
            Logger.getLogger(InterfazAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void LlenarHorarios(String f,int idBarbero){
        String sql = "SELECT agenda.id_agenda, agenda.nombre_cliente, agenda.id_barbero, barberos.nombre_usuario, servicios.id_servicio, servicios.servicio, agenda.confirmar, agenda.fecha, agenda.hora, servicios.duracion "
                + "FROM agenda, barberos, servicios "
                + "WHERE agenda.id_barbero = barberos.id_barbero AND agenda.fecha = '"+f+"' AND barberos.id_barbero = "+idBarbero+" AND agenda.id_servicio = servicios.id_servicio "
                + "ORDER BY agenda.hora ASC";
                
        String sql2;
        
        //System.out.println(sql);
        Object[] cliente = new Object [10];
        String hora;
        int contador = 0;
        
        LlenarHorarios2();
        try{
            Statement st,st2;
            ResultSet rs,rs2;

            st = conexion.cx.createStatement();
            st2 = conexion.cx.createStatement();
            
            rs = st.executeQuery(sql);
            while(rs.next()){
                cliente [0] = rs.getString(1);
                cliente [1] = rs.getString(2);
                cliente [2] = rs.getString(3);
                cliente [3] = rs.getString(4);
                cliente [4] = rs.getString(5);
                sql2 = "SELECT servicios.dur FROM servicios WHERE servicios.id_servicio = "+cliente[4]+" ";
                rs2 = st2.executeQuery(sql2);
                rs2.next();
                contador = rs2.getInt(1);
                //System.out.println(contador);
                
                cliente [5] = rs.getString(6);
                cliente [6] = rs.getString(7);
                cliente [7] = rs.getString(8);
                cliente [8] = rs.getString(9);
                hora = (String) cliente[8];
                //System.out.println(hora);
                cliente [9] = rs.getString(10);
                
                ActivarBanderas(contador,hora);
                LlenarHorarios2();
            }            
        }catch(SQLException e){
            
        }
    }
    
    void LlenarHorarios2(){
        SeleccionarHoraAgenda.removeAllItems();
        SeleccionarHoraAgenda.addItem("...");
        if(tiempo1 == false)
            SeleccionarHoraAgenda.addItem("9:00");
        if(tiempo2 == false)
            SeleccionarHoraAgenda.addItem("9:30");
        if(tiempo3 == false)
            SeleccionarHoraAgenda.addItem("10:00");
        if(tiempo4 == false)
            SeleccionarHoraAgenda.addItem("10:30");
        if(tiempo5 == false)
            SeleccionarHoraAgenda.addItem("11:00");
        if(tiempo6 == false)
            SeleccionarHoraAgenda.addItem("11:30");
        if(tiempo7 == false)
            SeleccionarHoraAgenda.addItem("12:00");
        if(tiempo8 == false)
            SeleccionarHoraAgenda.addItem("12:30");
        if(tiempo9 == false)
            SeleccionarHoraAgenda.addItem("13:00");
        if(tiempo10 == false)
            SeleccionarHoraAgenda.addItem("13:30");
        if(tiempo11 == false)
            SeleccionarHoraAgenda.addItem("14:00");
        if(tiempo12 == false)
            SeleccionarHoraAgenda.addItem("14:30");
        if(tiempo13 == false)
            SeleccionarHoraAgenda.addItem("15:00");
        if(tiempo14 == false)
            SeleccionarHoraAgenda.addItem("15:30");
        if(tiempo15 == false)
            SeleccionarHoraAgenda.addItem("16:00");
        if(tiempo16 == false)
            SeleccionarHoraAgenda.addItem("16:30");
        if(tiempo17 == false)
            SeleccionarHoraAgenda.addItem("17:00");
        if(tiempo18 == false)
            SeleccionarHoraAgenda.addItem("17:30");
        if(tiempo19 == false)
            SeleccionarHoraAgenda.addItem("18:00");
        if(tiempo20 == false)
            SeleccionarHoraAgenda.addItem("18:30");
        if(tiempo21 == false)
            SeleccionarHoraAgenda.addItem("19:00");
        if(tiempo22 == false)
            SeleccionarHoraAgenda.addItem("19:30");
        if(tiempo23 == false)
            SeleccionarHoraAgenda.addItem("20:00");
        if(tiempo24 == false)
            SeleccionarHoraAgenda.addItem("20:30");
        if(tiempo25 == false)
            SeleccionarHoraAgenda.addItem("21:00");
        if(tiempo26 == false)
            SeleccionarHoraAgenda.addItem("21:30");
        if(tiempo27 == false)
            SeleccionarHoraAgenda.addItem("22:00");
    }
    
    void VisualizarCitas(String f,int idBarbero){
        String sql = "SELECT agenda.id_agenda, agenda.nombre_cliente, agenda.id_barbero, barberos.nombre_usuario, servicios.id_servicio, servicios.servicio, agenda.confirmar, agenda.fecha, agenda.hora, servicios.duracion "
                + "FROM agenda, barberos, servicios "
                + "WHERE agenda.id_barbero = barberos.id_barbero AND agenda.fecha = '"+f+"' AND barberos.id_barbero = "+idBarbero+" AND agenda.id_servicio = servicios.id_servicio "
                + "ORDER BY agenda.hora ASC";
                
        String sql2;
        
        //System.out.println(sql);
        Object[] cliente = new Object [10];
        String hora;
        int contador = 0;
        
        try{
            Statement st,st2;
            ResultSet rs,rs2;

            st = conexion.cx.createStatement();
            st2 = conexion.cx.createStatement();
            
            rs = st.executeQuery(sql);
            while(rs.next()){
                cliente [0] = rs.getString(1);
                cliente [1] = rs.getString(2);
                cliente [2] = rs.getString(3);
                cliente [3] = rs.getString(4);
                cliente [4] = rs.getString(5);
                sql2 = "SELECT servicios.dur FROM servicios WHERE servicios.id_servicio = "+cliente[4]+" ";
                rs2 = st2.executeQuery(sql2);
                rs2.next();
                contador = rs2.getInt(1);
                //System.out.println(contador);
                
                cliente [5] = rs.getString(6);
                cliente [6] = rs.getString(7);
                cliente [7] = rs.getString(8);
                cliente [8] = rs.getString(9);
                hora = (String) cliente[8];
                //System.out.println(hora);
                cliente [9] = rs.getString(10);
                
                ActivarBanderas(contador,hora);
                EscribirHorarios();
            }            
        }catch(SQLException e){
            
        }
    }
    
    void EscribirHorarios(){
        if(tiempo1 == false)
            Hora1.setVisible(true);
        else
            Hora1.setVisible(false);
        if(tiempo2 == false)
            Hora2.setVisible(true);
        else
            Hora2.setVisible(false);
        if(tiempo3 == false)
            Hora3.setVisible(true);
        else
            Hora3.setVisible(false);
        if(tiempo4 == false)
            Hora4.setVisible(true);
        else
            Hora4.setVisible(false);
        if(tiempo5 == false)
            Hora5.setVisible(true);
        else
            Hora5.setVisible(false);
        if(tiempo6 == false)
            Hora6.setVisible(true);
        else
            Hora6.setVisible(false);
        if(tiempo7 == false)
            Hora7.setVisible(true);
        else
            Hora7.setVisible(false);
        if(tiempo8 == false)
            Hora8.setVisible(true);
        else
            Hora8.setVisible(false);
        if(tiempo9 == false)
            Hora9.setVisible(true);
        else
            Hora9.setVisible(false);
        if(tiempo10 == false)
            Hora10.setVisible(true);
        else
            Hora10.setVisible(false);
        if(tiempo11 == false)
            Hora11.setVisible(true);
        else
            Hora11.setVisible(false);
        if(tiempo12 == false)
            Hora12.setVisible(true);
        else
            Hora12.setVisible(false);
        if(tiempo13 == false)
            Hora13.setVisible(true);
        else
            Hora13.setVisible(false);
        if(tiempo14 == false)
            Hora14.setVisible(true);
        else
            Hora14.setVisible(false);
        if(tiempo15 == false)
            Hora15.setVisible(true);
        else
            Hora15.setVisible(false);
        if(tiempo16 == false)
            Hora16.setVisible(true);
        else
            Hora16.setVisible(false);
        if(tiempo17 == false)
            Hora17.setVisible(true);
        else
            Hora17.setVisible(false);
        if(tiempo18 == false)
            Hora18.setVisible(true);
        else
            Hora18.setVisible(false);
        if(tiempo19 == false)
            Hora19.setVisible(true);
        else
            Hora19.setVisible(false);
        if(tiempo20 == false)
            Hora20.setVisible(true);
        else
            Hora20.setVisible(false);
        if(tiempo21 == false)
            Hora21.setVisible(true);
        else
            Hora21.setVisible(false);
        if(tiempo22 == false)
            Hora22.setVisible(true);
        else
            Hora22.setVisible(false);
        if(tiempo23 == false)
            Hora23.setVisible(true);
        else
            Hora23.setVisible(false);
        if(tiempo24 == false)
            Hora24.setVisible(true);
        else
            Hora24.setVisible(false);
        if(tiempo25 == false)
            Hora25.setVisible(true);
        else
            Hora25.setVisible(false);
        if(tiempo26 == false)
            Hora26.setVisible(true);
        else
            Hora26.setVisible(false);
        if(tiempo27 == false)
            Hora27.setVisible(true);
        else
            Hora27.setVisible(false);
    }
    
    void ActivarBanderas(int contador, String hora){
        switch (hora) {
            case "9:00" -> {
                if(contador == 1)
                    tiempo1 = true;
                if(contador == 2){
                    tiempo1 = true;
                    tiempo2 = true;
                }   if (contador == 3){
                    tiempo1 = true;
                    tiempo2 = true;
                    tiempo3 = true;
                }   if(contador == 4){
                    tiempo1 = true;
                    tiempo2 = true;
                    tiempo3 = true;
                    tiempo4 = true;
                }
            }
            case "9:30" -> {
                if(contador == 1)
                    tiempo2 = true;
                if(contador == 2){
                    tiempo2 = true;
                    tiempo3 = true;
                }
                if (contador == 3){
                    tiempo2 = true;
                    tiempo3 = true;
                    tiempo4 = true;
                }
                if(contador == 4){
                    tiempo2 = true;
                    tiempo3 = true;
                    tiempo4 = true;
                    tiempo5 = true;
                }
            }
            case "10:00" -> {
                if(contador == 1)
                    tiempo3 = true;
                if(contador == 2){
                    tiempo3 = true;
                    tiempo4 = true;
                }
                if (contador == 3){
                    tiempo3 = true;
                    tiempo4 = true;
                    tiempo5 = true;
                }
                if(contador == 4){
                    tiempo3 = true;
                    tiempo4 = true;
                    tiempo5 = true;
                    tiempo6 = true;
                }
            }
            case "10:30" -> {
                if(contador == 1)
                    tiempo4 = true;
                if(contador == 2){
                    tiempo4 = true;
                    tiempo5 = true;
                }
                if (contador == 3){
                    tiempo4 = true;
                    tiempo5 = true;
                    tiempo6 = true;
                }
                if(contador == 4){
                    tiempo4 = true;
                    tiempo5 = true;
                    tiempo6 = true;
                    tiempo7 = true;
                }
            }
            case "11:00" -> {
                if(contador == 1)
                    tiempo5 = true;
                if(contador == 2){
                    tiempo5 = true;
                    tiempo6 = true;
                }
                if (contador == 3){
                    tiempo5 = true;
                    tiempo6 = true;
                    tiempo7 = true;
                }
                if(contador == 4){
                    tiempo5 = true;
                    tiempo6 = true;
                    tiempo7 = true;
                    tiempo8 = true;
                }
            }
            case "11:30" -> {
                if(contador == 1)
                    tiempo6 = true;
                if(contador == 2){
                    tiempo6 = true;
                    tiempo7 = true;
                }
                if (contador == 3){
                    tiempo6 = true;
                    tiempo7 = true;
                    tiempo8 = true;
                }
                if(contador == 4){
                    tiempo6 = true;
                    tiempo7 = true;
                    tiempo8 = true;
                    tiempo9 = true;
                }
            }
            case "12:00" -> {
                if(contador == 1)
                    tiempo7 = true;
                if(contador == 2){
                    tiempo7 = true;
                    tiempo8 = true;
                }
                if (contador == 3){
                    tiempo7 = true;
                    tiempo8 = true;
                    tiempo9 = true;
                }
                if(contador == 4){
                    tiempo7 = true;
                    tiempo8 = true;
                    tiempo9 = true;
                    tiempo10 = true;
                }
            }
            case "12:30" -> {
                if(contador == 1)
                    tiempo8 = true;
                if(contador == 2){
                    tiempo8 = true;
                    tiempo9 = true;
                }
                if (contador == 3){
                    tiempo8 = true;
                    tiempo9 = true;
                    tiempo10 = true;
                }
                if(contador == 4){
                    tiempo8 = true;
                    tiempo9 = true;
                    tiempo10 = true;
                    tiempo11 = true;
                }
            }
            case "13:00" -> {
                if(contador == 1)
                    tiempo9 = true;
                if(contador == 2){
                    tiempo9 = true;
                    tiempo10 = true;
                }
                if (contador == 3){
                    tiempo9 = true;
                    tiempo10 = true;
                    tiempo11 = true;
                }
                if(contador == 4){
                    tiempo9 = true;
                    tiempo10 = true;
                    tiempo11 = true;
                    tiempo12 = true;
                }
            }
            case "13:30" -> {
                if(contador == 1)
                    tiempo10 = true;
                if(contador == 2){
                    tiempo10 = true;
                    tiempo11 = true;
                }
                if (contador == 3){
                    tiempo10 = true;
                    tiempo11 = true;
                    tiempo12 = true;
                }
                if(contador == 4){
                    tiempo10 = true;
                    tiempo11 = true;
                    tiempo12 = true;
                    tiempo13 = true;
                }
            }
            case "14:00" -> {
                if(contador == 1)
                    tiempo11 = true;
                if(contador == 2){
                    tiempo11 = true;
                    tiempo12 = true;
                }
                if (contador == 3){
                    tiempo11 = true;
                    tiempo12 = true;
                    tiempo13 = true;
                }
                if(contador == 4){
                    tiempo11 = true;
                    tiempo12 = true;
                    tiempo13 = true;
                    tiempo14 = true;
                }
            }
            case "14:30" -> {
                if(contador == 1)
                    tiempo12 = true;
                if(contador == 2){
                    tiempo12 = true;
                    tiempo13 = true;
                }
                if (contador == 3){
                    tiempo12 = true;
                    tiempo13 = true;
                    tiempo14 = true;
                }
                if(contador == 4){
                    tiempo12 = true;
                    tiempo13 = true;
                    tiempo14 = true;
                    tiempo15 = true;
                }
            }
            case "15:00" -> {
                if(contador == 1)
                    tiempo13 = true;
                if(contador == 2){
                    tiempo13 = true;
                    tiempo14 = true;
                }
                if (contador == 3){
                    tiempo13 = true;
                    tiempo14 = true;
                    tiempo15 = true;
                }
                if(contador == 4){
                    tiempo13 = true;
                    tiempo14 = true;
                    tiempo15 = true;
                    tiempo16 = true;
                }
            }
            case "15:30" -> {
                if(contador == 1)
                    tiempo14 = true;
                if(contador == 2){
                    tiempo14 = true;
                    tiempo15 = true;
                }
                if (contador == 3){
                    tiempo14 = true;
                    tiempo15 = true;
                    tiempo16 = true;
                }
                if(contador == 4){
                    tiempo14 = true;
                    tiempo15 = true;
                    tiempo16 = true;
                    tiempo17 = true;
                }
            }
            case "16:00" -> {
                if(contador == 1)
                    tiempo15 = true;
                if(contador == 2){
                    tiempo15 = true;
                    tiempo16 = true;
                }
                if (contador == 3){
                    tiempo15 = true;
                    tiempo16 = true;
                    tiempo17 = true;
                }
                if(contador == 4){
                    tiempo15 = true;
                    tiempo16 = true;
                    tiempo17 = true;
                    tiempo18 = true;
                }
            }
            case "16:30" -> {
                if(contador == 1)
                    tiempo16 = true;
                if(contador == 2){
                    tiempo16 = true;
                    tiempo17 = true;
                }
                if (contador == 3){
                    tiempo16 = true;
                    tiempo17 = true;
                    tiempo18 = true;
                }
                if(contador == 4){
                    tiempo16 = true;
                    tiempo17 = true;
                    tiempo18 = true;
                    tiempo19 = true;
                }
            }
            case "17:00" -> {
                if(contador == 1)
                    tiempo17 = true;
                if(contador == 2){
                    tiempo17 = true;
                    tiempo18 = true;
                }
                if (contador == 3){
                    tiempo17 = true;
                    tiempo18 = true;
                    tiempo19 = true;
                }
                if(contador == 4){
                    tiempo17 = true;
                    tiempo18 = true;
                    tiempo19 = true;
                    tiempo20 = true;
                }
            }
            case "17:30" -> {
                if(contador == 1)
                    tiempo18 = true;
                if(contador == 2){
                    tiempo18 = true;
                    tiempo19 = true;
                }
                if (contador == 3){
                    tiempo18 = true;
                    tiempo19 = true;
                    tiempo20 = true;
                }
                if(contador == 4){
                    tiempo18 = true;
                    tiempo19 = true;
                    tiempo20 = true;
                    tiempo21 = true;
                }
            }
            case "18:00" -> {
                if(contador == 1)
                    tiempo19 = true;
                if(contador == 2){
                    tiempo19 = true;
                    tiempo20 = true;
                }
                if (contador == 3){
                    tiempo19 = true;
                    tiempo20 = true;
                    tiempo21 = true;
                }
                if(contador == 4){
                    tiempo19 = true;
                    tiempo20 = true;
                    tiempo21 = true;
                    tiempo22 = true;
                }
            }
            case "18:30" -> {
                if(contador == 1)
                    tiempo20 = true;
                if(contador == 2){
                    tiempo20 = true;
                    tiempo21 = true;
                }
                if (contador == 3){
                    tiempo20 = true;
                    tiempo21 = true;
                    tiempo22 = true;
                }
                if(contador == 4){
                    tiempo20 = true;
                    tiempo21 = true;
                    tiempo22 = true;
                    tiempo23 = true;
                }
            }
            case "19:00" -> {
                if(contador == 1)
                    tiempo21 = true;
                if(contador == 2){
                    tiempo21 = true;
                    tiempo22 = true;
                }
                if (contador == 3){
                    tiempo21 = true;
                    tiempo22 = true;
                    tiempo23 = true;
                }
                if(contador == 4){
                    tiempo21 = true;
                    tiempo22 = true;
                    tiempo23 = true;
                    tiempo24 = true;
                }
            }
            case "19:30" -> {
                if(contador == 1)
                    tiempo22 = true;
                if(contador == 2){
                    tiempo22 = true;
                    tiempo23 = true;
                }
                if (contador == 3){
                    tiempo22 = true;
                    tiempo23 = true;
                    tiempo24 = true;
                }
                if(contador == 4){
                    tiempo22 = true;
                    tiempo23 = true;
                    tiempo24 = true;
                    tiempo25 = true;
                }
            }
            case "20:00" -> {
                if(contador == 1)
                    tiempo23 = true;
                if(contador == 2){
                    tiempo23 = true;
                    tiempo24 = true;
                }
                if (contador == 3){
                    tiempo23 = true;
                    tiempo24 = true;
                    tiempo25 = true;
                }
                if(contador == 4){
                    tiempo23 = true;
                    tiempo24 = true;
                    tiempo25 = true;
                    tiempo26 = true;
                }
            }
            case "20:30" -> {
                if(contador == 1)
                    tiempo24 = true;
                if(contador == 2){
                    tiempo24 = true;
                    tiempo25 = true;
                }
                if (contador == 3){
                    tiempo24 = true;
                    tiempo25 = true;
                    tiempo26 = true;
                }
                if(contador == 4){
                    tiempo24 = true;
                    tiempo25 = true;
                    tiempo26 = true;
                    tiempo27 = true;
                }
            }
            case "21:00" -> {
                if(contador == 1)
                    tiempo25 = true;
                if(contador == 2){
                    tiempo25 = true;
                    tiempo26 = true;
                }
                if (contador >= 3){
                    tiempo25 = true;
                    tiempo26 = true;
                    tiempo27 = true;
                }
            }
            case "21:30" -> {
                if(contador == 1)
                    tiempo26 = true;
                if(contador >= 2){
                    tiempo26 = true;
                    tiempo27 = true;
                }
            }
            case "22:00" -> {
                tiempo27 = true;
            }
            default -> {
            }
        }
    }
    
    void VisualizarServiciosDuracion(){
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
                
        modelo.addColumn("Servicio");
        modelo.addColumn("Precio");
        modelo.addColumn("Duracion");
        TablaServiciosDuracion.setModel(modelo);
        
        String sql = "SELECT * FROM servicios ORDER BY dur ASC";
        //System.out.println(sql);
        Object[] cliente = new Object [3];
        
        try{
            Statement st;
            ResultSet rs;
            
            st = conexion.cx.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                rs = st.executeQuery(sql);
                rs.next();      //Servicio nulo
                while(rs.next()){
                    //rs.getInt("id");
                    cliente [0] = rs.getString(2);
                    cliente [1] = rs.getString(3);
                    cliente [2] = rs.getString(4);
                    modelo.addRow(cliente);
                }            
                TablaServiciosDuracion.setModel(modelo);
            }else{
                JOptionPane.showMessageDialog(null, "No se han registrado servicios.");
            }
        }catch(SQLException e){
            
        }
    }
    
    //----------------------------------------ServiciosDia--------------------------------------------------
    
    void ConsultarServiciosDia(String sql){
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
                
        modelo.addColumn("Precio");
        modelo.addColumn("Servicio");
        modelo.addColumn("Barbero");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        TablaServiciosDia.setModel(modelo);
       
        Object[] cliente = new Object [5];
        
        try{
            Statement st;
            ResultSet rs;
            int cont = 0;
            
            st = conexion.cx.createStatement();
            rs = st.executeQuery(sql);
            //ERROR modelo = (DefaultTableModel) TablaVentasServ.getModel();
            while(rs.next()){
                //rs.getInt("id");
                cliente [0] = "$"+rs.getString(1);
                cliente [1] = rs.getString(2);
                cliente [2] = rs.getString(3);
                cliente [3] = rs.getString(4);
                cliente [4] = rs.getString(5);
                modelo.addRow(cliente);
                cont++;
            }
            TablaServiciosDia.setModel(modelo);
            //RespuestaCantidadServ.setText(""+cont);
        }catch(SQLException e){
            
        }
    }
    
    void ConsultarProductosDia(String sql){
        DefaultTableModel modelo;
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };
                
        modelo.addColumn("Precio");
        modelo.addColumn("Producto");
        modelo.addColumn("Barbero");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        TablaProductosDia.setModel(modelo);
       
        Object[] cliente = new Object [5];
        
        try{
            Statement st;
            ResultSet rs;
            int cont = 0;
            
            st = conexion.cx.createStatement();
            rs = st.executeQuery(sql);
            //ERROR modelo = (DefaultTableModel) TablaVentasServ.getModel();
            while(rs.next()){
                //rs.getInt("id");
                cliente [0] = "$"+rs.getString(1);
                cliente [1] = rs.getString(2);
                cliente [2] = rs.getString(3);
                cliente [3] = rs.getString(4);
                cliente [4] = rs.getString(5);
                modelo.addRow(cliente);
                cont++;
            }
            TablaProductosDia.setModel(modelo);
            //RespuestaCantidadServ.setText(""+cont);
        }catch(SQLException e){
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgendaActualizar;
    private javax.swing.JButton BotonAgendaAgregar;
    private javax.swing.JButton BotonAgendaDeHoy;
    private javax.swing.JButton BotonAgendaLimpiar;
    private javax.swing.JButton BotonAgendaModificar;
    private javax.swing.JButton BotonAsistencia;
    private javax.swing.JButton BotonCambio;
    private javax.swing.JButton BotonConfirmarAgenda;
    private javax.swing.JButton BotonConfirmarInsercion;
    private javax.swing.JButton BotonConfirmarMostrar;
    private javax.swing.JButton BotonDesasistencia;
    private javax.swing.JButton BotonInicio;
    private javax.swing.JButton BotonInsertar;
    private javax.swing.JButton BotonMinimizar;
    private javax.swing.JToggleButton BotonOjo;
    private javax.swing.JButton BotonOtraInsercion;
    private javax.swing.JButton BotonPerfil;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BotonServiciosDia;
    private com.toedter.calendar.JDateChooser ElegirAgendaFecha;
    private javax.swing.JLabel FechaDeHoy;
    private javax.swing.JLabel Hora1;
    private javax.swing.JLabel Hora10;
    private javax.swing.JLabel Hora11;
    private javax.swing.JLabel Hora12;
    private javax.swing.JLabel Hora13;
    private javax.swing.JLabel Hora14;
    private javax.swing.JLabel Hora15;
    private javax.swing.JLabel Hora16;
    private javax.swing.JLabel Hora17;
    private javax.swing.JLabel Hora18;
    private javax.swing.JLabel Hora19;
    private javax.swing.JLabel Hora2;
    private javax.swing.JLabel Hora20;
    private javax.swing.JLabel Hora21;
    private javax.swing.JLabel Hora22;
    private javax.swing.JLabel Hora23;
    private javax.swing.JLabel Hora24;
    private javax.swing.JLabel Hora25;
    private javax.swing.JLabel Hora26;
    private javax.swing.JLabel Hora27;
    private javax.swing.JLabel Hora3;
    private javax.swing.JLabel Hora4;
    private javax.swing.JLabel Hora5;
    private javax.swing.JLabel Hora6;
    private javax.swing.JLabel Hora7;
    private javax.swing.JLabel Hora8;
    private javax.swing.JLabel Hora9;
    private javax.swing.JTextField LeerAgendaCliente;
    private javax.swing.JTextField LeerAgendaFecha;
    private javax.swing.JTextField LeerPagoCon;
    private javax.swing.JTextField RespuestaAgendaBarbero;
    private javax.swing.JTextField RespuestaAgendaId;
    private javax.swing.JTextField RespuestaAgendaIdBarbero;
    private javax.swing.JLabel RespuestaCambio;
    private javax.swing.JLabel RespuestaCambioTotal;
    private javax.swing.JLabel RespuestaProductoHecho;
    private javax.swing.JLabel RespuestaServicioHecho;
    private javax.swing.JScrollPane ScrollAgenda;
    private javax.swing.JScrollPane ScrollProductosDia;
    private javax.swing.JScrollPane ScrollServiciosDia;
    private javax.swing.JScrollPane ScrollServiciosDuracion;
    private javax.swing.JComboBox<Barberos> SeleccionarAgendaBarbero;
    private javax.swing.JComboBox<Barberos> SeleccionarBarbero;
    private javax.swing.JComboBox<String> SeleccionarHoraAgenda;
    private javax.swing.JComboBox<String> SeleccionarMostrar;
    private javax.swing.JComboBox<Productos> SeleccionarProducto;
    private final javax.swing.JComboBox<Servicios> SeleccionarServicio = new javax.swing.JComboBox<>();
    private javax.swing.JComboBox<Servicios> SeleccionarServicioAgenda;
    private javax.swing.JTable TablaAgenda;
    private javax.swing.JTable TablaProductosDia;
    private javax.swing.JTable TablaServiciosDia;
    private javax.swing.JTable TablaServiciosDuracion;
    private javax.swing.JLabel TextoAddBarberos;
    private javax.swing.JLabel TextoAddProductos;
    private javax.swing.JLabel TextoAddServicios;
    private javax.swing.JLabel TextoAgendaBarbero;
    private javax.swing.JLabel TextoAgendaCliente;
    private javax.swing.JLabel TextoAgendaFecha;
    private javax.swing.JLabel TextoAgendaId;
    private javax.swing.JLabel TextoBarraganThe;
    private javax.swing.JLabel TextoCambio;
    private javax.swing.JLabel TextoCambioTotal;
    private javax.swing.JLabel TextoCitas;
    private javax.swing.JLabel TextoHoraAgenda;
    private javax.swing.JLabel TextoPagoCon;
    private javax.swing.JLabel TextoProductoHecho;
    private javax.swing.JLabel TextoSecretaria;
    private javax.swing.JLabel TextoServicioAgenda;
    private javax.swing.JLabel TextoServicioHecho;
    private javax.swing.JLabel TextoServiciosDuracion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
