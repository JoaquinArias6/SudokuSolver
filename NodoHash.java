class NodoHash {
    
    private int digito;
    private int fila;
    private int columna;
    private int subgrillFila;
    private int subgrillColumna;
    private NodoHash sig;

    //constructor 
    public NodoHash() {
        this.digito = 0;
        this.fila = -1;
        this.columna = -1;
        this.subgrillFila = -1;
        this.subgrillColumna = -1;
        this.sig = null;
    }
    
    //setters
    public void setDigito(int digito){
        this.digito = digito;
    }

    public void setFila(int fila){
        this.fila = fila;
    }

    public void setColumna(int columna){
        this.columna = columna;
    }

    public void setFilaSubgrill(int subFila){
        this.subgrillFila = subFila;
    }

    public void setColumnaSubgrill(int subCol){
        this.subgrillColumna = subCol;
    }

    public void setearSig(NodoHash nodo){
        this.sig= nodo;
    }

    //getters
    public int getDigito(){
        return this.digito;
    }
    
    public int getFila(){
        return this.fila;
    }

    public int getColumna(){
        return this.columna;
    }

    public int getFilaSubgrilla(){
        return this.subgrillFila;
    }

    public int getColumnaSubgrilla(){
        return this.subgrillColumna;
    }

    public NodoHash avanzar(){
        return this.sig;
    }


    //operaciones auxiliares

    //setea un numero de subgrilla en base a las filas y columnas previamente asignadas
    public void asignarSub(){

        boolean seEncontro = false;
        int l = 0;
        int colum = 0;

        while (( l < 3) && (!seEncontro)){
            int k = 0;
            while ((k < 3)&&(!seEncontro)) {
                seEncontro = ((this.fila>=l*3)&&(this.fila<l*3+3)&&(this.columna>=k*3)&&(this.columna<k*3+3));
                k++;
            }
            l++;
            colum = k;
        }
        this.setFilaSubgrill(l-1);
        this.setColumnaSubgrill(colum-1);
    }

}
