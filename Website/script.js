function field_focus(field, email)
  {
    if(field.value == email)
    {
      field.value = '';
    }
  }

  function field_blur(field, email)
  {
    if(field.value == '')
    {
      field.value = email;
    }
  }

  function login(form)
  {
    if(form.email.value == "raunak" && form.pwd.value == "mokhasi")
    {
        window.open("http://localhost/dslinternshipwebsite/quotes.html","_self")
        return true;
  	}
  	else
  	{
  	    alert("Error Password or Username")
  	    return false;
    }
  }

  function getQuote(form, category)
  {
    var promise1 = new Promise(function(resolve, reject) {
      var xhr = new XMLHttpRequest(),
        method = "GET",
        url = "http://quotes.rest/qod.json?category=" + category;

      xhr.open(method, url, true);
      xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
          resolve(JSON.parse(xhr.responseText));
        }
      };
      xhr.send();
    });

    promise1.then(function(value) {
      alert (value.contents.quotes[0].quote);
    });
  }

//Fade in dashboard box
$(document).ready(function(){
    $('.box').hide().fadeIn(1000);
    });

//Stop click event
$('a').click(function(event){
    event.preventDefault(); 
	});