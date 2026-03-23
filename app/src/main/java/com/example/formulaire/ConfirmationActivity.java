package com.example.formulaire;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    // ── 1. Références vers les vues de cet écran ─────────────────────────────
    private TextView tvFicheAdherent;
    private Button   btnRevenir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation); // Lier le XML de cet écran

        // ── 2. Récupérer les vues par leurs IDs ──────────────────────────────
        tvFicheAdherent = findViewById(R.id.tvFicheAdherent);
        btnRevenir      = findViewById(R.id.btnRevenir);

        // ── 3. Récupérer l'Intent qui a lancé cet écran ───────────────────────
        Intent intentRecu = getIntent();

        // ── 4. Extraire chaque donnée envoyée depuis MainActivity ────────────
        //       getStringExtra("clé") ← même clé utilisée dans putExtra()
        String prenom    = intentRecu.getStringExtra(MainActivity.CLE_PRENOM);
        String nomFamille = intentRecu.getStringExtra(MainActivity.CLE_NOM);
        String mail      = intentRecu.getStringExtra(MainActivity.CLE_MAIL);
        String telephone = intentRecu.getStringExtra(MainActivity.CLE_TELEPHONE);
        String quartier  = intentRecu.getStringExtra(MainActivity.CLE_QUARTIER);

        // ── 5. Composer la fiche adhérent (texte multi-lignes) ───────────────
        String ficheAdherent =
                "👤  Prénom       : " + afficher(prenom)    + "\n" +
                        "📋  Nom          : " + afficher(nomFamille) + "\n" +
                        "✉️   E-mail       : " + afficher(mail)      + "\n" +
                        "📞  Téléphone    : " + afficher(telephone)  + "\n" +
                        "📍  Quartier     : " + afficher(quartier);

        // ── 6. Injecter le texte dans le TextView ─────────────────────────────
        tvFicheAdherent.setText(ficheAdherent);

        // ── 7. Bouton Retour : finish() ferme cet écran et revient au formulaire
        btnRevenir.setOnClickListener(v -> finish());
    }

    // ── Méthode utilitaire : retourne "—" si la chaîne est nulle ou vide ─────
    private String afficher(String valeur) {
        return (valeur == null || valeur.trim().isEmpty()) ? "—" : valeur.trim();
    }
}