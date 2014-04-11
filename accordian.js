 $(function() {
    var icons = {
      header: "ui-icon-circle-triangle-e",
      activeHeader: "ui-icon-circle-triangle-s"
    };
    $( "#accordion" ).accordion({
		collapsible: true, icons: icons
    });
  });
