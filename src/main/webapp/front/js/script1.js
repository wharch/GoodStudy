$('.button').click(function(){
  var buttonId = $(this).attr('id');
  $(this).parent().parent().next().removeAttr('class').addClass(buttonId);
  $('body').addClass('modal-active');
})

$('.close').click(function(){
  $(this).addClass('out');
  $('body').removeClass('modal-active');
});