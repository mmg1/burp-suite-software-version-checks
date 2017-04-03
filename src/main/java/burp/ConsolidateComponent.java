package burp;

import burp.IBurpExtenderCallbacks;

/**
 * @author August Detlefsen [augustd at codemagi dot com]
 */
public class ConsolidateComponent extends javax.swing.JPanel {

	IBurpExtenderCallbacks mCallbacks;
	
	private static final String SETTING_CONSOLIDATE = "O_CONSOLIDATE";

	/**
	 * Creates new ConsolidateComponent
	 *
	 * @param callbacks For UI Look and Feel
	 */
	public ConsolidateComponent(IBurpExtenderCallbacks callbacks) {
		mCallbacks = callbacks;

		initComponents();

		mCallbacks.customizeUiComponent(jCheckBoxConsolidate);

		restoreSavedSettings();
	}

	/**
	 * Allows the developer to set the default value for selected tools, not
	 * every tool makes sense for every extension
	 *
	 * @param tool
	 * @param enabled
	 */
	public void setDefault(boolean enabled) {
		if (mCallbacks.loadExtensionSetting(SETTING_CONSOLIDATE) == null) {
			jCheckBoxConsolidate.setSelected(enabled);
		}
	}

	/**
	 * Returns true if the consolidate checkbox is selected in the GUI
	 *
	 * @param tool
	 * @return whether the selected tool is selected
	 */
	public boolean isConsolidated() {
		boolean selected = false;
		selected = jCheckBoxConsolidate.isSelected() && jCheckBoxConsolidate.isEnabled();
		return selected;
	}

	/**
	 * Save all configured settings
	 */
	public void saveSettings() {
		mCallbacks.saveExtensionSetting(SETTING_CONSOLIDATE, setSetting(jCheckBoxConsolidate.isSelected()));
	}

	/**
	 * Restores any found saved settings
	 */
	public void restoreSavedSettings() {
		if (mCallbacks.loadExtensionSetting(SETTING_CONSOLIDATE) != null) {
			jCheckBoxConsolidate.setSelected(getSetting(SETTING_CONSOLIDATE));
		}
	}

	/**
	 * Get the boolean value of the requested setting
	 *
	 * @param name
	 * @return whether the setting was selected
	 */
	private boolean getSetting(String name) {
		return mCallbacks.loadExtensionSetting(name).equals("ENABLED") == true;
	}

	private String setSetting(boolean value) {
		return value ? "ENABLED" : "DISABLED";
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBoxConsolidate = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 137, 0));
        jLabel1.setText("Results");

        jCheckBoxConsolidate.setSelected(true);
        jCheckBoxConsolidate.setText("Consolidate");
        jCheckBoxConsolidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxConsolidateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 137, 0));

        jLabel4.setText("Select the checkbox to consolidate duplicate results from the same domain:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBoxConsolidate)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxConsolidate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxConsolidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxConsolidateActionPerformed
		saveSettings();
    }//GEN-LAST:event_jCheckBoxConsolidateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxConsolidate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}