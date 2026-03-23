package com.example.formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // ── 1. Déclaration des références vers les champs de saisie ──────────────
    private EditText etPrenom, etNomFamille, etMail, etTelephone, etQuartier;

    // ── 2. Déclaration du bouton d'inscription ───────────────────────────────
    private Button btnInscrire;

    // ── 3. Constantes pour les clés d'extras (évite les fautes de frappe) ────
    public static final String CLE_PRENOM     = "prenom";
    public static final String CLE_NOM        = "nom_famille";
    public static final String CLE_MAIL       = "mail";
    public static final String CLE_TELEPHONE  = "telephone";
    public static final String CLE_QUARTIER   = "quartier";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ── 4. Cycle de vie : méthode appelée à la création de l'écran ───────
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Lier l'UI XML à cette Activity

        // ── 5. Récupérer les vues grâce à leurs identifiants XML ─────────────
        etPrenom     = findViewById(R.id.etPrenom);
        etNomFamille = findViewById(R.id.etNomFamille);
        etMail       = findViewById(R.id.etMail);
        etTelephone  = findViewById(R.id.etTelephone);
        etQuartier   = findViewById(R.id.etQuartier);
        btnInscrire  = findViewById(R.id.btnInscrire);

        // ── 6. Réaction au clic sur "S'inscrire" ─────────────────────────────
        btnInscrire.setOnClickListener(v -> {

            // 6.1 — Lire et nettoyer la saisie (trim supprime les espaces)
            String sPrenom    = etPrenom.getText().toString().trim();
            String sNom       = etNomFamille.getText().toString().trim();
            String sMail      = etMail.getText().toString().trim();
            String sTelephone = etTelephone.getText().toString().trim();
            String sQuartier  = etQuartier.getText().toString().trim();

            // 6.2 — Validation : champs obligatoires (Prénom + Mail)
            if (sPrenom.isEmpty() || sMail.isEmpty()) {
                Toast.makeText(this,
                        "Le Prénom et l'E-mail sont obligatoires.",
                        Toast.LENGTH_SHORT).show();
                return; // On arrête ici, rien n'est envoyé
            }

            // 6.3 — Validation : format de l'adresse e-mail
            if (!Patterns.EMAIL_ADDRESS.matcher(sMail).matches()) {
                Toast.makeText(this,
                        "Adresse e-mail invalide.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // 6.4 — Créer un Intent EXPLICITE vers l'écran de confirmation
            //        Intent explicite = on désigne la classe cible directement
            Intent intentConfirm = new Intent(MainActivity.this,
                    ConfirmationActivity.class);

            // 6.5 — Passer les données sous forme de paires clé/valeur (extras)
            intentConfirm.putExtra(CLE_PRENOM,    sPrenom);
            intentConfirm.putExtra(CLE_NOM,       sNom);
            intentConfirm.putExtra(CLE_MAIL,      sMail);
            intentConfirm.putExtra(CLE_TELEPHONE, sTelephone);
            intentConfirm.putExtra(CLE_QUARTIER,  sQuartier);

            // 6.6 — Démarrer l'Activity de confirmation
            startActivity(intentConfirm);
        });
    }

    // ── 7. (Bonus) Vider le formulaire à chaque retour sur cet écran ─────────
    @Override
    protected void onResume() {
        super.onResume();
        // Décommenter les lignes ci-dessous si on veut réinitialiser les champs
        // etPrenom.setText("");    etNomFamille.setText("");
        // etMail.setText("");      etTelephone.setText("");
        // etQuartier.setText("");
    }
}