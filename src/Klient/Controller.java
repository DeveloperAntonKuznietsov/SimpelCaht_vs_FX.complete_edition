package Klient;

import Networks.TCPConnection;
import Networks.TCPConnectionListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.IOException;

public class Controller implements  TCPConnectionListener {
    @FXML
    TextField txtInput;
    @FXML
    Button btnSend;
    @FXML
    TextArea log;
    @FXML
    TextField txtNickName;
    @FXML
    Label lblCount;
    @FXML
    Label lblDate;

    private static final String IP_ADDR = "127.0.0.1 ";
    private static final int PORT = 8889;
    private TCPConnection connection;
    private int countMsg = 0;
    Data s =new Data();
    private final Sound SOUND = new Sound();

    @FXML
    public void initialize(){
        log.setEditable(false);

        btnSend.setOnAction(event -> {
            String msg = txtInput.getText();
            if(msg.equals(""))return;
            txtInput.setText("");
            connection.sendString(s.data()+txtNickName.getText() + ": " + msg,SOUND);

            countMsg++;
             lblCount.setText("Count : "+countMsg);
            });


        printMsg(txtInput.getText());

        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            printMsg("Connection exception: " + e);
        }
    }


    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Connection ready...");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMsg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMsg("Connection close");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
            printMsg("Connection exception: " + e);
    }

    private synchronized void printMsg(String msg) {
        log.appendText(msg + "\n");
        }

}



