 $(function() {
    var icons = {
      header: "ui-icon-circle-triangle-e",
      activeHeader: "ui-icon-circle-triangle-s"
    };
    $( "#accordion" ).accordion({
		collapsible: true, icons: icons
    });
  });


// Was able to simplify originial code (below) to create the same feature above 

$(document).ready(function(){
     $(".extsubmenu").hide();
     $(".extcontainerheader").addClass("containerarrow");
     $(".extcontainerheader").click(function(){
       var index = $(".extcontainerheader").index(this);
       $(".extsubmenu").animate({ height: 'hide', opacity: 'hide' }, 'slow');
       $(".extcontainerheader").removeClass("containerarrow containerarrowdown").addClass("containerarrow");
       if($(".extsubmenu").eq(index).is(":hidden"))
       {
         $(".extsubmenu").eq(index).animate({ height: 'show', opacity: 'show' }, 'slow');
         $(".extcontainerheader").eq(index).removeClass("containerarrow").addClass("containerarrowdown");
       }
     });
 });

//Extendable Container JS for Directory 
$(document).ready(function(){
     $(".extsubmenu1").hide();
     $(".extcontainerheader1").addClass("containerarrow1");
     $(".extcontainerheader1").click(function(){
       var index = $(".extcontainerheader1").index(this);
       $(".extsubmenu1").animate({ height: 'hide', opacity: 'hide' }, 'slow');
       $(".extcontainerheader1").removeClass("containerarrow1 containerarrowdown1").addClass("containerarrow1");
       if($(".extsubmenu1").eq(index).is(":hidden"))
       {
         $(".extsubmenu1").eq(index).animate({ height: 'show', opacity: 'show' }, 'slow');
         $(".extcontainerheader1").eq(index).removeClass("containerarrow1").addClass("containerarrowdown1");
       }
