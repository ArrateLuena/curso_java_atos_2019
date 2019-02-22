/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wkClases;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios {
    private List <Usuario> user;
    
    private ListaUsuarios() {
        user = new ArrayList<>();
    }
    
    public static ListaUsuarios getInstance() {
        
        return ListaUsuariosHolder.INSTANCE;
    }

    private static class ListaUsuariosHolder {

        private static final ListaUsuarios INSTANCE = new ListaUsuarios();
    }
}

