const slider = document.querySelector('.slider');
let isDown = false;
let startX;
let scrollLeft;

slider.addEventListener('mousedown', (e) => {
  isDown = true;
  startX = e.pageX - slider.offsetLeft;
  scrollLeft = slider.scrollLeft;
});
slider.addEventListener('mouseleave', () => {
  isDown = false;
});
slider.addEventListener('mouseup', () => {
  isDown = false;
});
slider.addEventListener('mousemove', (e) => {
  if(!isDown) return;
  e.preventDefault();
  const x = e.pageX - slider.offsetLeft;
  const walk = (x - startX) * 3; //scroll-fast
  slider.scrollLeft = scrollLeft - walk;
});

const slideItem = slider.lastElementChild;
let walk = slideItem.offsetWidth;
let x = 0;
let dx = 0;
let time = 0;
let startTime = new Date().getTime();
let scroll = false;

setInterval(() =>{
    time += new Date().getTime() - startTime;
    console.log(time)
    startTime = new Date().getTime();
    if(time >= 2000 && !scroll){
        dx = 20;
        time = 0;
        scroll = true;
    }
    if (x < walk){
        x += dx;
        slider.scrollLeft += dx;
    }else{
        dx = 0;
        x = 0;
        scroll = false;
    }
    if (slider.offsetWidth + slider.scrollLeft >= slider.scrollWidth){
        dx = -20;
    }
    if (slider.scrollLeft == 0) {
        x = 0;
        dx = 0;
        scroll = false;
    }
    console.log(scroll)
}, 30)