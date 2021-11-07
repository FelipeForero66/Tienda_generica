package com.mintic.tienda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.mintic.tienda.jwt.JWTAuthorizationFilter;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);

		/* contador array */

		/*
		 * int[] numeros = { 1, 1, 3, 4, 1, 2, 3 }; Arrays.sort(numeros);
		 * 
		 * String p = ""; for (int i = 1; i <= 5; i++) {
		 * 
		 * for (int a = 0; a < numeros.length; a++) {
		 * 
		 * if (numeros[a] == i) { p = p.concat("*"); }
		 * 
		 * } System.out.println(i + ":" + p); p = ""; }
		 */

		/* array simetrico */

		/*
		 * String[] letras = { "a", "b", "c", "d", "d", "c", "b", "a" }; String response
		 * = "";
		 * 
		 * int tamanio = letras.length % 2;
		 * 
		 * int contador = 0;
		 * 
		 * if (tamanio != 0) { System.out.println("no es simetrica"); } else { for (int
		 * i = 0; i < letras.length / 2; i++) {
		 * 
		 * if (letras[i].equals(letras[letras.length - 1 - i])) { contador = contador +
		 * 1; } }
		 * 
		 * if (contador == letras.length / 2) { System.out.println("simetrica"); } else
		 * { System.out.println("no simetrica"); } }
		 * 
		 * int cantidad =8;
		 * 
		 * int[][]arreglo = new int[cantidad][cantidad];
		 * 
		 * for ( int i=0; i < arreglo.length ;i++){ for (int j=0; j<arreglo.length;j++){
		 * int x = i + 1; if((i==j) || (j == (cantidad - x))){ arreglo[i][j] = 1;
		 * System.out.print("X "); } else{ arreglo[i][j] = 9; System.out.print("_  "); }
		 * } System.out.println(); }
		 */

	}

}
