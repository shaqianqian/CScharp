function construitColonnesJours(largeur) {
    var Cols = [];
    for (var i = 0; i < Jours.length; i++) {
        var div_col = document.createElement("div");
        div_col.className = "col-sm-" + largeur;
        div_col.setAttribute("id", Jours[i]);
        var c = new Col(div_col, Jours[i]);
        Cols.push(c);

    }
    return Cols;

}

function construitPanel() {
    var creneaus = [];
    for (var i = 0; i < lesSoutenances.length; i++) {
        var creneau = new Creneau(lesSoutenances[i].debut, lesSoutenances[i].etudiant, lesSoutenances[i].societe, lesSoutenances[i].tuteur,
            lesSoutenances[i].specialite, lesSoutenances[i].jour);
        creneaus.push(creneau);
    }
    return creneaus;
}

function Plan(balise, jours, largeur) {
    this.balise = balise;
    this.jours = jours;
    this.largeur = largeur;
    this.cols = construitColonnesJours(largeur);
    this.creneaus = construitPanel();

}

function Col(balise, jour) {
    this.balise = balise;
    this.jour = jour;
}

function Creneau(debut, etudiant, societe, tuteur, specialite, jour) {
    this.debut = debut;
    this.etudiant = etudiant;
    this.societe = societe;
    this.tuteur = tuteur;
    this.specialite = specialite;
    this.jour = jour;
    this.pied = Salles[specialite][jour] + "/" + specialite;

}


function tire_temps() {
    lesSoutenances.sort(function (a, b) {
        return new Date("2018/9/" + a.jour + " " + a.debut) - new Date("2018/9/" + b.jour + " " + b.debut);
    });

}


function affiche(p) {
    for (var i = 0; i < p.creneaus.length; i++) {

        var div_panel = document.createElement("div");

        div_panel.className = "panel " + CouleursPanel[p.creneaus[i].specialite];

        var div_head = document.createElement("div");
        div_head.className = "panel-heading";
        var b = document.createElement("b");
        var temp = document.createTextNode(p.creneaus[i].debut);

        b.appendChild(temp);
        div_head.appendChild(b);
        div_panel.appendChild(div_head);

        var div_body = document.createElement("div");
        div_body.className = "panel-body";
        div_body.appendChild(document.createTextNode(p.creneaus[i].etudiant));
        div_body.appendChild(document.createElement("br"));
        div_body.appendChild(document.createTextNode(p.creneaus[i].tuteur));
        div_body.appendChild(document.createElement("br"));
        div_body.appendChild(document.createTextNode(p.creneaus[i].societe));
        div_panel.appendChild(div_body);


        var div_footer = document.createElement("div");
        div_footer.className = "panel-footer";
        div_footer.appendChild(document.createTextNode(p.creneaus[i].jour + "/" + p.creneaus[i].pied));
        div_panel.appendChild(div_footer);
        for (var j = 0; j < p.jours.length; j++) {

            if (p.creneaus[i].jour == p.cols[j].jour) {
                p.cols[j].balise.appendChild(div_panel);
                // Cols[j].balise.appendChild(div_panel);
            }

        }

    }

    var element = p.balise;
    for (var j = 0; j < Jours.length; j++) {
        element.appendChild(p.cols[j].balise);


    }

}
function razCreneaux(){
    var balise_mere=document.getElementById("Planning");
    var childs = balise_mere.childNodes;
    for(var i = childs.length - 1; i >= 0; i--) {
        balise_mere.removeChild(childs[i]);
    }

}
function afficheCreneaux(){
    this.razCreneaux();
    var p = new Plan(document.getElementById("Planning"), ["04", "05", "06", "07"], 3);
    this.affiche(p);


}
function conditionCreneaux(condition){

    this.razCreneaux();
    var p = new Plan(document.getElementById("Planning"), ["04", "05", "06", "07"], 3);
    for (var i = 0; i < p.creneaus.length; i++) {

        var div_panel = document.createElement("div");

        div_panel.className = "panel " + CouleursPanel[p.creneaus[i].specialite];

        var div_head = document.createElement("div");
        div_head.className = "panel-heading";
        var b = document.createElement("b");
        var temp = document.createTextNode(p.creneaus[i].debut);

        b.appendChild(temp);
        div_head.appendChild(b);
        div_panel.appendChild(div_head);

        var div_body = document.createElement("div");
        div_body.className = "panel-body";
        div_body.appendChild(document.createTextNode(p.creneaus[i].etudiant));
        div_body.appendChild(document.createElement("br"));
        div_body.appendChild(document.createTextNode(p.creneaus[i].tuteur));
        div_body.appendChild(document.createElement("br"));
        div_body.appendChild(document.createTextNode(p.creneaus[i].societe));
        div_panel.appendChild(div_body);


        var div_footer = document.createElement("div");
        div_footer.className = "panel-footer";
        div_footer.appendChild(document.createTextNode(p.creneaus[i].jour + "/" + p.creneaus[i].pied));
        div_panel.appendChild(div_footer);
        for (var j = 0; j < p.jours.length; j++) {

            if (p.creneaus[i].jour == p.cols[j].jour&&p.creneaus[i].specialite==condition) {
                p.cols[j].balise.appendChild(div_panel);
                // Cols[j].balise.appendChild(div_panel);
            }

        }

    }

    var element = p.balise;
    for (var j = 0; j < Jours.length; j++) {
        element.appendChild(p.cols[j].balise);


    }


}
function conditionSalle(salle){

    this.razCreneaux();
    var p = new Plan(document.getElementById("Planning"), ["04", "05", "06", "07"], 3);
    for (var i = 0; i < p.creneaus.length; i++) {

        var div_panel = document.createElement("div");

        div_panel.className = "panel " + CouleursPanel[p.creneaus[i].specialite];

        var div_head = document.createElement("div");
        div_head.className = "panel-heading";
        var b = document.createElement("b");
        var temp = document.createTextNode(p.creneaus[i].debut);

        b.appendChild(temp);
        div_head.appendChild(b);
        div_panel.appendChild(div_head);

        var div_body = document.createElement("div");
        div_body.className = "panel-body";
        div_body.appendChild(document.createTextNode(p.creneaus[i].etudiant));
        div_body.appendChild(document.createElement("br"));
        div_body.appendChild(document.createTextNode(p.creneaus[i].tuteur));
        div_body.appendChild(document.createElement("br"));
        div_body.appendChild(document.createTextNode(p.creneaus[i].societe));
        div_panel.appendChild(div_body);


        var div_footer = document.createElement("div");
        div_footer.className = "panel-footer";
        div_footer.appendChild(document.createTextNode(p.creneaus[i].jour + "/" + p.creneaus[i].pied));
        div_panel.appendChild(div_footer);
        for (var j = 0; j < p.jours.length; j++) {

            if (p.creneaus[i].jour == p.cols[j].jour&&Salles[p.creneaus[i].specialite][p.creneaus[i].jour]==salle) {
                p.cols[j].balise.appendChild(div_panel);
                // Cols[j].balise.appendChild(div_panel);
            }

        }

    }

    var element = p.balise;
    for (var j = 0; j < Jours.length; j++) {
        element.appendChild(p.cols[j].balise);


    }


}
window.onload = function () {
    this.tire_temps();
    var p = new Plan(document.getElementById("Planning"), ["04", "05", "06", "07"], 3);
    this.affiche(p);


};

