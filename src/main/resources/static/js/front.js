document.getElementById("defaultOpen").click();
function openFunc(evt, tabName) {
  // Declare all variables
  var i, multabContent, multab;

  // Get all elements with class="multabContent" and hide them
  multabContent = document.getElementsByClassName("multabContent");
  for (i = 0; i < multabContent.length; i++) {
    multabContent[i].style.display = "none";
  }

  // Get all elements with class="multab" and remove the class "active"
  multab = document.getElementsByClassName("multab");
  for (i = 0; i < multab.length; i++) {
    multab[i].className = multab[i].className.replace(" active", "");
  }

  // Show the current tab, and add an "active" class to the button that opened the tab
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
} 