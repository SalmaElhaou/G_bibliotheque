package testUnit;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;

import objets_metiers.Exemplaire;
import objets_metiers.Oeuvre;
import Utility.BibalExceptions;
import control.ExemplaireControl;

public class ExemplaireControlTest {

    @Test
    public void testAjouter() throws BibalExceptions {
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setId(1);
        oeuvre.setTitre("Les Misérables");
        oeuvre.setAuteur("Victor Hugo");
        
        ExemplaireControl.ajouter(oeuvre, "neuf");
        assertEquals(1, oeuvre.getExamplairesOeuvre());
    }

    @Test
    public void testModifier() throws BibalExceptions  {
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(1);
        exemplaire.setEtat("abimé");
        ExemplaireControl.modifier(exemplaire);
        assertEquals("abimé", exemplaire.getEtat());
    }

    @Test
    public void testSupprimer() throws BibalExceptions  {
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setId(1);
        exemplaire.setEtat("neuf");
        ExemplaireControl.supprimer(exemplaire);
        assertNull(ExemplaireControl.findById(1));
    }

    @Test
    public void testFindById() throws BibalExceptions  {
        Exemplaire exemplaire = ExemplaireControl.findById(1);
        assertNotNull(exemplaire);
    }

    @Test
    public void testFindExemplaireDispo() throws BibalExceptions  {
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setId(1);
        ArrayList<Exemplaire> exemplairesDispo = ExemplaireControl.findExemplaireDispo(oeuvre);
        assertNotNull(exemplairesDispo);
    }

    @Test
    public void testFind() throws BibalExceptions  {
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setId(1);
        ArrayList<Exemplaire> exemplaires = ExemplaireControl.find(oeuvre);
        assertNotNull(exemplaires);
    }
   
}
