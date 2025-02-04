/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import napakalaki.Treasure; 
/**
 *
 * @author Javi
 */
public class TreasureView extends javax.swing.JPanel {
        
        private Treasure treasureModel;
        private boolean selected=false;
        
        
        public boolean isSelected(){
            return selected;
            
        }
        
        public Treasure getTreasure(){
            return treasureModel;
        }
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
    }

    
    public void setTreasure (Treasure t) {
        treasureModel = t;
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TreasuresImages/"+treasureModel.getName())));
        repaint(); 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 255));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 132, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (selected)
            selected=false;
        else
            selected=true;
        setOpaque(selected);
        repaint();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
