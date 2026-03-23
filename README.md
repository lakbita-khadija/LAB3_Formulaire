# 📚 Bibliothèque Municipale — Application Android

Application Android développée dans le cadre d'un TP universitaire.  
Elle permet à un utilisateur de remplir un formulaire d'inscription à une bibliothèque, puis de visualiser un récapitulatif de ses informations sur un second écran.

---

## 🎯 Objectif du projet

Implémenter une navigation entre deux activités Android en transmettant des données via un **Intent explicite**, tout en appliquant des validations de base sur les champs du formulaire.

---

## 📱 Fonctionnalités

- Saisie des informations de l'adhérent (Prénom, Nom, E-mail, Téléphone, Quartier)
- Validation des champs obligatoires (Prénom + E-mail)
- Validation du format de l'adresse e-mail
- Affichage d'un récapitulatif sur un second écran
- Retour au formulaire via `finish()`

---
## 🎥 Démonstration



https://github.com/user-attachments/assets/49153edd-738d-473e-978a-68282fb33aad



## 🗂️ Structure du projet

```
app/
├── java/com.example.formulaire/
│   ├── MainActivity.java           # Écran 1 : formulaire d'inscription
│   └── ConfirmationActivity.java   # Écran 2 : récapitulatif
│
├── res/layout/
│   ├── activity_main.xml           # UI du formulaire
│   └── activity_confirmation.xml   # UI du récapitulatif
│
└── AndroidManifest.xml             # Déclaration des deux activités
```

---

## ⚙️ Installation & Lancement

### Prérequis
- Android Studio (version récente recommandée)
- SDK Android API 24 minimum (Android 7.0)
- Émulateur ou appareil physique Android

### Étapes

1. **Cloner le projet**
   ```bash
   git clone https://github.com/lakbita-khadija/LAB3_Formulaire
   ```

2. **Ouvrir dans Android Studio**
   ```
   File → Open → sélectionner le dossier du projet
   ```

3. **Synchroniser Gradle**
   ```
   File → Sync Project with Gradle Files
   ```

4. **Lancer l'application**
   - Sélectionner un émulateur ou un appareil connecté
   - Cliquer sur ▶️ **Run**

---

## 🧠 Concepts Android utilisés

| Concept | Description |
|---|---|
| `ScrollView` + `LinearLayout` | Mise en page verticale avec défilement |
| `EditText` + `inputType` | Champs de saisie avec clavier adapté (email, téléphone…) |
| `Button` + `setOnClickListener` | Réaction aux actions de l'utilisateur |
| `Intent` explicite | Navigation ciblée vers une Activity connue |
| `putExtra` / `getStringExtra` | Transmission de données entre activités (clé/valeur) |
| `finish()` | Fermeture de l'activité courante et retour en arrière |
| `Patterns.EMAIL_ADDRESS` | Validation du format d'une adresse e-mail |
| `onResume()` | Cycle de vie : méthode appelée au retour sur un écran |
| `AndroidManifest.xml` | Déclaration obligatoire de toutes les activités |

---

## 👨‍💻 Auteur

Projet réalisé dans le cadre d'un TP Android — Formation développement mobile.

---

