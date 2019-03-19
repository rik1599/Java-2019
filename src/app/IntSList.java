package app;

/**
 * IntSList s = new IntSList();   (list)
 * 
 * s.nullList()     -> boolean    (null? s)
 * s.car()          -> int        (car s)
 * s.cdr()          -> IntSList   (cdr s)
 * s.cons(int n)    -> IntSList   (cons s n)
 */
public class IntSList {

  //#region variabili
  private boolean empty;
  private int first;
  private IntSList rest;

  public IntSList() {
    this.empty = true;
    this.first = 0;
    this.rest = null;
  }

  public IntSList(int n, IntSList s) {
    this.empty = false;
    this.first = n;
    this.rest = s;
  }

  public boolean nullList() {
    return this.empty;
  }

  public int car() {
    return this.first;
  }

  public IntSList cdr() {
    return rest;
  }

  public IntSList cons(int n) {
    return new IntSList(n, this);
  }
} // class IntSList