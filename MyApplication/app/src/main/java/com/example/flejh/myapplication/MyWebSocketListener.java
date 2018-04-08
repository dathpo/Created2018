package com.example.flejh.myapplication;

import android.widget.TextView;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class MyWebSocketListener extends WebSocketListener {
    private TextView output;
    private static final int NORMAL_CLOSURE_STATUS = 1000;

    public MyWebSocketListener(TextView output) {
        this.output = output;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        output("open");
        webSocket.send("Hello, it's ME !");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        output("New data : " + text);
    }
    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        output("Receiving bytes : " + bytes.hex());
    }
    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
        output("Closing : " + code + " / " + reason);
    }
    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        output("Error : " + t.getMessage());
    }

    private void output(final String data) {
        output.post(new Runnable() {
            @Override
            public void run() {
                output.setText(data);
            }
        });
    }
}
