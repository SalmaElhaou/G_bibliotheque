package testUnit;

import static org.junit.Assert.*;
import objets_metiers.Emprunt;
import objets_metiers.Exemplaire;
import objets_metiers.Oeuvre;
import objets_metiers.Usager;
import Utility.BibalExceptions;
import control.EmpruntControl;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import control.OeuvreControl;

public class OeuvreControlTest {
    
    private Oeuvre oeuvre;
    private Oeuvre oeuvre2;

    @Before
    public void setUp() {
        oeuvre = new Oeuvre();
        oeuvre2 = new Oeuvre();
    }
    
    @Test
    public void testAjouter() throws BibalExceptions {
        OeuvreControl.ajouter(oeuvre);
        ArrayList<Oeuvre> oeuvres = OeuvreControl.getListOeuvres();
        assertTrue(oeuvres.contains(oeuvre));
    }
    
    @Test
    public void testModifier() throws BibalExceptions {
        OeuvreControl.ajouter(oeuvre);
        oeuvre.setTitre("nouveauTitre");
        OeuvreControl.modifier(oeuvre);
        Oeuvre oeuvreModifiee = OeuvreControl.findById(oeuvre.getId());
        assertEquals("nouveauTitre", oeuvreModifiee.getTitre());
    }
    
    @Test
    public void testSupprimer() throws BibalExceptions {
        OeuvreControl.ajouter(oeuvre);
        OeuvreControl.supprimer(oeuvre);
        ArrayList<Oeuvre> oeuvres = OeuvreControl.getListOeuvres();
        assertFalse(oeuvres.contains(oeuvre));
    }
    
    @Test
    public void testFindById() throws BibalExceptions {
        OeuvreControl.ajouter(oeuvre);
        Oeuvre oeuvreTrouvee = OeuvreControl.findById(oeuvre.getId());
        assertEquals(oeuvre, oeuvreTrouvee);
    }
    
    @Test
    public void testFindByTitre() throws BibalExceptions {
        OeuvreControl.ajouter(oeuvre);
        OeuvreControl.ajouter(oeuvre2);
        ArrayList<Oeuvre> oeuvresTrouvees = OeuvreControl.findByTitre("titre1");
        assertTrue(oeuvresTrouvees.contains(oeuvre));
        assertFalse(oeuvresTrouvees.contains(oeuvre2));
    }

}
