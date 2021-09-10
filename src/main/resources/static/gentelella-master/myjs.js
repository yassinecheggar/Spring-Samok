var tonner;

function printtabe() {
  var s = new String();
  $.get("http://localhost:8080/clients", function(data, status) {
    var x = document.getElementById("ttable");
    for (var i = 0; i < data.length; i++) {

      s = s + '<tr><td ><a href="">' + data[i].id + "</a></td>" +
        "<td >" + data[i].nom + "</td>" +
        "<td >" + data[i].adresse + "</td>" +
        "<td >" + data[i].email + "</td>" +
        "<td >" + data[i].telephone + "</td>"

        +
        "</tr>";
    }
    x.innerHTML = s;
  });
};

function printtabeM() {
  var s = new String();
  $.get("http://localhost:8080/clientMorale", function(data, status) {
    var x = document.getElementById("tabem");
    for (var i = 0; i < data.length; i++) {

      s = s + '<tr><td ><a href="">' + data[i].id + "</a></td>" +
        "<td >" + data[i].numeroPatente + "</td>" +
        "<td >" + data[i].numeroRegistreCommerce + "</td>" +
        "<td >" + data[i].raisonSocial + "</td>"


        +
        "</tr>";
    }
    x.innerHTML = s;
  });
};

function printtabeP() {
  var s = new String();
  $.get("http://localhost:8080/clientPhysique", function(data, status) {
    var x = document.getElementById("tableP");

    for (var i = 0; i < data.length; i++) {
      if (data[i].dateNaissance != null) {
        todo = data[i].dateNaissance.substring(0, 10);
      }

      s = s + '<tr><td ><a href="">' + data[i].id + "</a></td>" +

        "<td >" + data[i].cin + "</td>" +
        "<td >" + data[i].nom + "</td>" +
        "<td >" + data[i].prenom + "</td>" +
        "<td >" + todo + "</td>" +
        "<td >" + data[i].lieuNaissance + "</td>" +
        "<td >" + data[i].nationalite + "</td>" +
        "<td >" + data[i].situationFamiliale + "</td>" +
        "<td >" + data[i].numeroCarteCredit + "</td>"

        +
        "</tr>";
    }
    x.innerHTML = s;
  });
};

function changelabel(name, inner) {

  var label = document.getElementById(name);
  label.innerHTML = inner;
}

function sleep(seconds) {
  var e = new Date().getTime() + (seconds * 1000);
  while (new Date().getTime() <= e) {}
}




//----------------------searrcheclient---------------------------------------------------------
function printdataclient(datax) {
  var label1 = document.getElementById("nom");
  label1.innerHTML = datax.nom;
  var label2 = document.getElementById("email");
  label2.innerHTML = datax.email;

  var label3 = document.getElementById("adresse");
  label3.innerHTML = datax.adresse;
  var label4 = document.getElementById("telephone");
  label4.innerHTML = datax.telephone;
}

function searchwithID(url) {
  var s = document.getElementById('Searchid').value;
  var datax;
  $.get(url + s, function(data, status) {
    if (Array.isArray(data) ) {

       printdataclient(data[dataindex]);
var page = document.getElementById("page");
       page.innerHTML= '<ul class="pagination ">'+
         '<li class="paginate_button previous" id="previous"><a  aria-controls="datatable" onclick="previousc()">Previous</a></li>'+

         '<li class="paginate_button next " id="next"><a  aria-controls="datatable" onclick="nextc() ">Next</a></li> </ul>';
          dataglobale = data;

    }

    if (Array.isArray(data)==false ) {

    printdataclient(data) ;

    }


  });

};
//------------------------------------------------------------------------------------------


//----------------------searrcheclientM---------------------------------------------------------

function searchwithIDM(url) {
  var s = document.getElementById('Searchid').value;
  $.get(url + s, function(data, status) {
    var label1 = document.getElementById("id");
    label1.innerHTML = data.id;
    var label2 = document.getElementById("Registre");
    label2.innerHTML = data.numeroRegistreCommerce;

    var label3 = document.getElementById("Raison");
    label3.innerHTML = data.raisonSocial;
    var label4 = document.getElementById("Patente");
    label4.innerHTML = data.numeroPatente;

  });

};


function searchwithIDphy(datap) {


    var lab = document.getElementById("id");
    lab.innerHTML = datap.id;

    var lab = document.getElementById("cin");
    lab.innerHTML = datap.cin;

    var label2 = document.getElementById("nom");
    label2.innerHTML = datap.nom;

    var label3 = document.getElementById("prenom");
    label3.innerHTML = datap.prenom;
    var label4 = document.getElementById("date");
    label4.innerHTML = datap.dateNaissance.substring(0, 10);

    var label5 = document.getElementById("lieu");
    label5.innerHTML = datap.lieuNaissance;
    var label6 = document.getElementById("nation");
    label6.innerHTML = datap.nationalite;

    var label6 = document.getElementById("situation");
    label6.innerHTML = datap.situationFamiliale;

    var label7 = document.getElementById("numero");
    label7.innerHTML = datap.numeroCarteCredit;



};
var dataglobale;
function searchwithCINphy(url) {
  var s = document.getElementById('Searchid').value;
  $.get(url + s, function(data, status) {
    alert(s);
    console.log(Array.isArray(data));
    if(Array.isArray(data) == false){
      alert("data singel");
     searchwithIDphy(data) ;
    }
    if(Array.isArray(data) ){
      alert('data row');
      var page = document.getElementById("paging");
          searchwithIDphy(data[dataindex]);
      page.innerHTML= '<ul class="pagination ">'+
        '<li class="paginate_button previous" id="previous"><a  aria-controls="datatable" onclick="previous()">Previous</a></li>'+

        '<li class="paginate_button next " id="next"><a  aria-controls="datatable" onclick="next() ">Next</a></li> </ul>';


        dataglobale = data;
        }
    });


};
var dataindex = 0;
function next() {
 var size = dataglobale.length;
    if (dataindex < size) {
      dataindex = dataindex + 1;
      searchwithIDphy(dataglobale[dataindex]);
    }
}
function nextc() {
 var size = dataglobale.length;
    if (dataindex < size) {
      dataindex = dataindex + 1;
      printdataclient(dataglobale[dataindex]);
    }
}




function previous() {
 var size = dataglobale.length;
  if(dataindex > 0){
    dataindex = dataindex - 1;
searchwithIDphy(dataglobale[dataindex]);
  }
}
function previousc() {
 var size = dataglobale.length;
  if(dataindex > 0){
    dataindex = dataindex - 1;
printdataclient(dataglobale[dataindex]);
  }
}


//-------------------------------------------------------------------------------------------------

//---------------------------search to alter client----------------------------------------------------
function searchwithIDAlter() {
  var s = document.getElementById('Searchid').value;
  $.get("http://localhost:8080/clients/" + s, function(data, status) {
    var input1 = document.getElementById("nom");
    input1.value = data.nom;
    var input2 = document.getElementById("email");
    input2.value = data.email;

    var input3 = document.getElementById("adresse");
    input3.value = data.adresse;
    var input4 = document.getElementById("telephone");
    input4.value = data.telephone;

  });

} //-----------------------------------------------------------------------------------------------------

//---------------------------search to alter clientM----------------------------------------------------

function searchwithIDAlterM(url) {
  var s = document.getElementById('Searchid').value;
  $.get(url + s, function(data, status) {

    var lab = document.getElementById("Patante1");
    lab.value = data.numeroPatente;

    var label2 = document.getElementById("Registre");
    label2.value = data.numeroRegistreCommerce;

    var label3 = document.getElementById("Raison");
    label3.value = data.raisonSocial;



  });

};
//-------------------------------------------------------------------------------------------------------

function searchwithIDAlterPhy(url) {
  var s = document.getElementById('Searchid').value;
  $.get(url + s, function(data, status) {


    var lab = document.getElementById("cin");
    lab.value = data.cin;

    var label2 = document.getElementById("nom");
    label2.value = data.nom;

    var label3 = document.getElementById("prenom");
    label3.value = data.prenom;
    var label4 = document.getElementById("date");
    label4.value = data.dateNaissance.substring(0, 10);


    var label5 = document.getElementById("lieu");
    label5.value = data.lieuNaissance;
    var label6 = document.getElementById("nation");
    label6.value = data.nationalite;

    var label6 = document.getElementById("situation");
    label6.value = data.situationFamiliale;

    var label7 = document.getElementById("numero");
    label7.value = data.numeroCarteCredit;




  });
}
//transforme the data to jSon type
function addM() {
  var form = document.getElementById('moraleform');

  var data = toJSONString(form);


  PostClient(data, "http://localhost:8080/clientMorale");
  // alert("dd");
  sleep(1);
}
//-------------------addclient Ph-----------------------------
function addPhy() {
  var form = document.getElementById('clientPhysfrom');

  var data = toJSONString(form);

  console.log(data);

  PostClient(data, "http://localhost:8080/clientPhysique");
  // alert("dd");
  sleep(0.5);
}
//----------------------------------------------------------------------------------------------------------
function tojson() {
  var form = document.getElementById('clientForm');

  var data = toJSONString(form);

  console.log(data);
  PostClient(data, "http://localhost:8080/clients");
  alert("dd");
}

//serialization ---------------------
function toJSONString(form) {
  var obj = {};
  var elements = form.querySelectorAll("input, select, textarea");
  for (var i = 0; i < elements.length; ++i) {
    var element = elements[i];
    var name = element.name;
    var value = element.value;

    if (name) {
      obj[name] = value;
    }
  }

  return JSON.stringify(obj);
}

function PostClient(x, ur) {

  $.ajax({
    type: "POST",
    url: ur,
    // The key needs to match your method's input parameter (case-sensitive).
    data: x,
    contentType: "application/json",
    dataType: "json",
    success: function(data) {
      alert("added");
    },
    failure: function(errMsg) {
      alert(errMsg);
    }
  });


}
//-------------- update client-----------------------------------------------
function PutClient() {
  s = document.getElementById("Searchid").value;
  alert(s);
  form = document.getElementById('clientForm');
  data = toJSONString(form);

  putc(data, s);

}

function putc(x, s) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/clients/" + s,
    // The key needs to match your method's input parameter (case-sensitive).
    data: x,
    contentType: "application/json",
    dataType: "json",
    success: function(data) {
      alert("changes applied");
    },
    failure: function(errMsg) {
      alert(errMsg);
    }

  });
sleep(0.1);
}
//----------------------------------------------------------------------------

//-------------- update M-----------------------------------------------
function PutClientM() {
  s = document.getElementById("Searchid").value;
  alert(s);
  form = document.getElementById('moraleForm');

  data = toJSONString(form);

  putM(data, s);
  console.log(data);
  sleep(0.1);
}


function putM(x, s) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/clientMorale/" + s,
    // The key needs to match your method's input parameter (case-sensitive).
    data: x,
    contentType: "application/json",
    dataType: "json",
    success: function(data) {
      alert("changes applied");
    },
    failure: function(errMsg) {
      alert(errMsg);
    }
  });

}
//-------------------------------------------------------------------------------
function PutClientPhy() {
  s = document.getElementById("Searchid").value;

  form = document.getElementById('clientPhysfrom');

  data = toJSONString(form);

  putPhy(data, s);

  sleep(1);
}


function putPhy(x, s) {
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/clientPhysique/" + s,

    data: x,
    contentType: "application/json",
    dataType: "json",
    success: function(data) {
      alert("changes applied");
    },
    failure: function(errMsg) {
      alert(errMsg);
    }
  });

}

 function witheid() {
tonner = document.getElementById('id1').innerHTML;


}

function witheRaison() {
tonner = document.getElementById('R1').innerHTML;


}

function withcin(){
    tonner = document.getElementById('cin1').innerHTML;
}

function withnom(){
    tonner = document.getElementById('nom1').innerHTML;
}

function withPrenom(){
    tonner = document.getElementById('prenom1').innerHTML;

}


function selectsearchtype() {
  if (tonner == "ID") {

    searchwithCINphy("http://localhost:8080/clientPhysique/");
  }

  if (tonner == "CIN") {

    searchwithCINphy("http://localhost:8080/clientPhysiqueC/");
  }

  if (tonner == "Nom") {

    searchwithCINphy("http://localhost:8080/clientPhysiqueN/");
  }

  if (tonner == "Prenom") {

    searchwithCINphy("http://localhost:8080/clientPhysiqueP/");
  }
}

function selectModiftype() {
  if (tonner == "ID") {
alert('id');
    searchwithIDAlterPhy("http://localhost:8080/clientPhysique/");
  }

  if (tonner == "CIN") {

    searchwithIDAlterPhy("http://localhost:8080/clientPhysiqueC/");
  }


}

function selectsearchtypeM() {
  if (tonner == "ID") {

    searchwithIDM("http://localhost:8080/clientMorale/");
  }

  if (tonner == "Raison Social") {
alert('msg');
    searchwithIDM("http://localhost:8080/clientMoraleR/");
  }


}
function selectmodiftypeM() {
  if (tonner == "ID") {

    searchwithIDAlterM("http://localhost:8080/clientMorale/");
  }

  if (tonner == "Raison Social") {

    searchwithIDAlterM("http://localhost:8080/clientMoraleR/");
  }


}

function selectsearchClient() {
  if (tonner == "ID") {

    searchwithID("http://localhost:8080/clients/");
  }

  if (tonner == "Nom") {

    searchwithID("http://localhost:8080/clientsN/");
  }


}
