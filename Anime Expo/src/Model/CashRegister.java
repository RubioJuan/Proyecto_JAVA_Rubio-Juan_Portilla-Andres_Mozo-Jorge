/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.math.BigDecimal;


/**
 *
 * @author Jorge Luis Mozo
 */
public class CashRegister {
    private int register_id;
    private String status;
    private int operator;
    private BigDecimal opening_amount;
    private BigDecimal closing_amount;
    
    public CashRegister(){} 
    
    
    public CashRegister(int register_id, String status, int operator, BigDecimal opening_amount, BigDecimal closing_amount) {
        this.register_id = register_id;
        this.status = status;
        this.operator = operator;
        this.opening_amount = opening_amount;
        this.closing_amount = closing_amount;
    }
    
     public int getRegister_id() {
        return register_id;
    }

    public void setRegister_id(int register_id) {
        this.register_id = register_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public BigDecimal getOpening_amount() {
        return opening_amount;
    }

    public void setOpening_amount(BigDecimal opening_amount) {
        this.opening_amount = opening_amount;
    }

    public BigDecimal getClosing_amount() {
        return closing_amount;
    }

    public void setClosing_amount(BigDecimal closing_amount) {
        this.closing_amount = closing_amount;
    }
}
