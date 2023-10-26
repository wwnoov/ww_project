// 텍스트 작성과 삭제 즉시 실행 함수
(function(){
    // DOM에서 <main> 요소 내의 <h2> 요소 내의 <span> 요소를 찾습니다.
    const spanEl = document.querySelector("main h2 span");
    // 텍스트 배열을 정의합니다.
    const txtArr = ['wwnoov', 'Full-Stack Developer', '남원우', 'UX Designer', 'Good Developer'];
    // 텍스트 배열의 인덱스를 추적하기 위한 변수를 초기화합니다.
    let index = 0;
    // 현재 텍스트 배열의 요소를 문자 배열로 분할합니다.
    let currentTxt = txtArr[index].split("");
    // 텍스트를 추가하는 함수를 정의합니다.
    function writeTxt(){
      spanEl.textContent  += currentTxt.shift(); 
      // 현재 문자 배열에 더 이상 문자가 남아 있으면 임의의 시간 간격 후 다음 문자를 추가합니다.
      if(currentTxt.length !== 0){ 
        setTimeout(writeTxt, Math.floor(Math.random() * 100));
      }else{
        currentTxt = spanEl.textContent.split("");
        setTimeout(deleteTxt, 3000);
      }
    }
    // 텍스트를 삭제하는 함수를 정의합니다.
    function deleteTxt(){
      currentTxt.pop();
      spanEl.textContent = currentTxt.join("");
      // 현재 문자 배열에 더 이상 문자가 남아 있으면 임의의 시간 간격 후 다음 문자를 삭제합니다.
      if(currentTxt.length !== 0){
        setTimeout(deleteTxt, Math.floor(Math.random() * 100))
      }else{
        index = (index + 1) % txtArr.length;
        currentTxt = txtArr[index].split("");
        writeTxt();
      }
    }
     // 초기로 텍스트 추가 함수를 호출하여 타이핑 애니메이션을 시작합니다.
    writeTxt();
  })();
  
  /* 수직 스크롤이 발생하면 header 태그에 active 클래스 추가 및 삭제 */
  const headerEl = document.querySelector("header");
  window.addEventListener('scroll', function(){
    requestAnimationFrame(scrollCheck);
  });
  function scrollCheck(){
    let browerScrollY = window.scrollY ? window.scrollY : window.pageYOffset;
    if(browerScrollY > 0){
      headerEl.classList.add("active");
    }else{
      headerEl.classList.remove("active");
    }
  }
  /* 애니메이션 스크롤 이동 */
  const animationMove = function(selector){
    // ① selector 매개변로 이동할 대상 요소 노드 가져오기
    const targetEl = document.querySelector(selector);
    // ② 현재 브라우저의 스크롤 정보(y 값)
    const browserScrollY = window.pageYOffset;
    // ③ 이동할 대상의 위치(y 값)
    const targetScorllY = targetEl.getBoundingClientRect().top + browserScrollY;
    // ④ 스크롤 이동
    window.scrollTo({ top: targetScorllY, behavior: 'smooth' });
  };
  // 스크롤 이벤트 연결하기
  const scollMoveEl = document.querySelectorAll("[data-animation-scroll='true']"); 
  for(let i = 0; i < scollMoveEl.length; i++){
    scollMoveEl[i].addEventListener('click', function(e){
      const target = this.dataset.target;
      animationMove(target);
    });
  }