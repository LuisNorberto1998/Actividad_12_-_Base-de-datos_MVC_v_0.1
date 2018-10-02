/*
 * Controlador para el programa de Conexion de una base de datos
 * con modelo MVC
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewAgenda;
import models.ModelAgenda;

/**
 *
 * @author Norberto
 */
public class ControllerAgenda implements ActionListener {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;

    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        this.viewAgenda.jbtn_primero.addActionListener(this);
        this.viewAgenda.jbtn_anterior.addActionListener(this);
        this.viewAgenda.jbtn_siguiente.addActionListener(this);
        this.viewAgenda.jbtn_ultimo.addActionListener(this);
        components();
        consulta();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAgenda.jbtn_primero) {
            btnPrimero();
        } else if (e.getSource() == viewAgenda.jbtn_anterior) {
            btnAnterior();
        } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
            btnSiguiente();
        } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
            btnUltimo();
        }
    }

    private void btnPrimero() {
        modelAgenda.primerRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
    }

    private void btnAnterior() {
        modelAgenda.anteriorRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
    }

    private void btnSiguiente() {
        modelAgenda.siguienteRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
    }

    private void btnUltimo() {
        modelAgenda.ultimoRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
    }

    private void components() {
        viewAgenda.setTitle("Actividad 12 - Base de datos MVC v 0.1");
        viewAgenda.setResizable(false);
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setVisible(true);
    }

    private void consulta() {
        modelAgenda.consultaSql();
        viewAgenda.jtf_id.setText(String.valueOf(modelAgenda.getId().toString()));
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
    }

}
