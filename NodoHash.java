class NodoHash {
    
    private int digito;
    private int fila;
    private int columna;
    private int subgrill;
    private NodoHash sig;

    //constructor 
    public NodoHash() {
        this.digito = 0;
        this.fila = 0;
        this.columna = 0;
        this.subgrill = 0;
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

    public void setSubGrill(int subgrilla){
        this.subgrill = subgrilla;
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

    public int getSubgrilla(){
        return this.subgrill;
    }

    public NodoHash avanzar(){
        return this.sig;
    }


    public void setearSig(NodoHash nodo){
        this.sig= nodo;
    }

    public boolean esIgual(NodoHash nodo){
        boolean parametro = ((this.fila == nodo.fila)&&(this.columna == nodo.columna)&&(this.subgrill == nodo.subgrill));
        return parametro;
    }
}
