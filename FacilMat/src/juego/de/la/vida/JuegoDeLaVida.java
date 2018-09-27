/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.de.la.vida;

import java.awt.image.BufferedImage;

public class JuegoDeLaVida {
    
    //private BufferedImage imagen;
    int generacion=0, limi=0,lims=499, poblacion=5;
    BufferedImage imagen = new BufferedImage(lims+1, lims+1, BufferedImage.TYPE_INT_RGB);
    int mat[][]=new int[lims+1][lims+1];
    int mat2[][]=new int[lims+1][lims+1];
    int vivos=0;
    
    void inicializar(){
        generacion=0;
        for(int i=0;i<lims+1;i++){
            for(int j=0;j<lims+1;j++){
                mat[i][j]=-1;
                mat2[i][j]=-1;
            }
        }
        /*for(int i=3;i<7;i+=1){
            for(int j=3;j<7;j+=1){
                mat[i][j]=-16777216;
            }
        }*/
        mat[lims/2][(lims/2)+1]=-16777216;
        mat[(lims/2)+1][(lims/2)+1]=-16777216;
        mat[(lims/2)+1][(lims/2)+2]=-16777216;
        mat[(lims/2)+1][(lims/2)+3]=-16777216;
        mat[(lims/2)+2][(lims/2)+2]=-16777216;
        
        /*mat[limi][(limi)+1]=-16777216;
        mat[(limi)+1][(limi)+1]=-16777216;
        mat[(limi)+1][(limi)+2]=-16777216;
        mat[(limi)+1][(limi)+3]=-16777216;
        mat[(limi)+2][(limi)+2]=-16777216;
        
        mat[lims/3][(lims/3)+1]=-16777216;
        mat[(lims/3)+1][(lims/3)+1]=-16777216;
        mat[(lims/3)+1][(lims/3)+2]=-16777216;
        mat[(lims/3)+1][(lims/3)+3]=-16777216;
        mat[(lims/3)+2][(lims/3)+2]=-16777216;*/
    }
    
    BufferedImage generacion(){
        generacion++;
        System.out.print("\n");
        for(int i=0;i<lims+1;i++){
            for(int j=0;j<lims+1;j++){
                
                vivos=0;
                
                    if(i==lims){
                        if(mat[limi][j]==-16777216){
                            vivos++;      
                        }
                    }
                    else{
                        if(mat[i+1][j]==-16777216){
                            vivos++;      
                        }
                    }                      
                    if(i==limi){
                        if(mat[lims][j]==-16777216){
                            vivos++;      
                        }    
                    }
                    else{
                        if(mat[i-1][j]==-16777216){
                            vivos++;      
                        }    
                    }
                    if(j==lims){
                        if(mat[i][limi]==-16777216){
                            vivos++;      
                        }
                    }
                    else{
                        if(mat[i][j+1]==-16777216){
                            vivos++;      
                        }
                    }
                    if(j==limi){
                        if(mat[i][lims]==-16777216){
                            vivos++;      
                        }
                    }
                    else{
                        if(mat[i][j-1]==-16777216){
                            vivos++;      
                        }
                    }
                    //esquinas
                    if(i==lims && j==limi){
                        if(mat[limi][lims]==-16777216){
                                vivos++;      
                            }
                    }
                    else{
                        if(i==lims){
                            if(mat[limi][j-1]==-16777216){
                                vivos++;      
                            }
                        }
                        else if(j==limi){
                            if(mat[i+1][lims]==-16777216){
                                vivos++;      
                            }
                        }
                        else{
                            if(mat[i+1][j-1]==-16777216){
                                vivos++;      
                            }
                        }
                    }
                    if(i==limi && j==limi){
                        if(mat[lims][lims]==-16777216){
                                vivos++;      
                            }
                    }
                    else{                                     
                        if(i==limi){
                            if(mat[lims][j-1]==-16777216){
                                vivos++;      
                            }
                        }
                        else if(j==limi){
                            if(mat[i-1][lims]==-16777216){
                                vivos++;      
                            }
                        }
                        else{
                            if(mat[i-1][j-1]==-16777216){
                                vivos++;      
                            }
                        }
                    }
                    if(i==lims && j==lims){
                        if(mat[limi][limi]==-16777216){
                                vivos++;      
                            }
                    }
                    else{
                        if(i==lims){
                            if(mat[limi][j+1]==-16777216){
                                vivos++;      
                            }
                        }
                        else if(j==lims){
                            if(mat[i+1][limi]==-16777216){
                                vivos++;      
                            }
                        }
                        else{
                            if(mat[i+1][j+1]==-16777216){
                                vivos++;      
                            }
                        }
                    }
                    if(i==limi && j==lims){
                        if(mat[lims][limi]==-16777216){
                                vivos++;      
                            }  
                    }
                    else{
                        if(i==limi){
                            if(mat[lims][j+1]==-16777216){
                                vivos++;      
                            }
                        }
                        else if(j==lims){
                            if(mat[i-1][limi]==-16777216){
                                vivos++;      
                            }
                        }
                        else{
                            if(mat[i-1][j+1]==-16777216){
                                vivos++;      
                            }                        
                        }
                    }
                //si esta viva
                if(mat[i][j]==-16777216){   
                    imagen.setRGB(i,j,-16777216);
                    //System.out.print(1);
                    switch(vivos){
                        case 2: mat2[i][j]=-16777216; break;
                        case 3: mat2[i][j]=-16777216; break;
                        default: mat2[i][j]=-1; poblacion--; break;
                    }
                }
                //si esta muerta
                else if(mat[i][j]==-1){               
                    imagen.setRGB(i,j,-1);
                    //System.out.print(0);
                    switch(vivos){
                        case 3: mat2[i][j]=-16777216; poblacion++; break;
                        case 4: mat2[i][j]=-16777216; poblacion++; break;
                        default: mat2[i][j]=-1; break;
                    }
                }
            }
            //System.out.print("\n");
        }
        for(int i=0;i<lims+1;i++)
        {
            for(int j=0;j<lims+1;j++)
            {
                mat[i][j]=mat2[i][j];
            }
        }        
     return imagen;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
