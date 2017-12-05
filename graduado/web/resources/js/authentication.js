/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    var img = ["img/backgrounds/img1.jpg", "img/backgrounds/img2.png", "img/backgrounds/img2.jpg"];
    var color = ["#007bff", "#29363d;", "#009bc9;"];
    function myfunction() {
        console.log('ejecutando');
        var lenght = img.length;
        var lenght1 = color.length;
        var id = Math.floor((Math.random() * lenght1));

        //$('.app-background').css("background-image", 'url("' + img[id] + '")');
        $('.app-background').css("background-color", 'none');
        $('.app-background').css("background-color", color[id]);
        $('.app-background').show("explode", {pieces: 16}, 2000);
    }
  //  setInterval(myfunction, 3000);
})