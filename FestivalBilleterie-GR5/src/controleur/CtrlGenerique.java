
package controleur;

import vue.VueGenerique;

/**
 *
 * @author Sacha Djurdjevic
 */
public abstract class CtrlGenerique {
    
    protected VueGenerique vue = null;
    protected CtrlPrincipal ctrlPrincipal = null;
    
    protected CtrlGenerique(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
    public VueGenerique getVue() {
        return vue;
    }

    public void setVue(VueGenerique vue) {
        this.vue = vue;
    }

    public CtrlPrincipal getCtrlPrincipal() {
        return (CtrlPrincipal)ctrlPrincipal;
    }

    public void setCtrlPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    } 
    
}
