package it.unibo.mostra.db.api;


/**
 * Interface that manages employee specializations.
 */
public interface Personale {
    /**
     * 
     * @return employee's salary.
     */
    Integer getStipendio();
    /**
     * 
     * @return employee's serial number.
     */
    String getMatricola();
    /**
     * 
     * @return employee's contract code.
     */
    String getCodiceContratto();
}
