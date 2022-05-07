function setMinHeightForLeftAndRightComponents(): void{
    const loginLeftComponent: HTMLElement = document.querySelector('.login__left')
    const loginRightComponent: HTMLElement = document.querySelector('.login__right')

    let innerWidth: number = window.innerWidth

    if (innerWidth >= 768){
        let avaiHeight = window.outerHeight

        loginLeftComponent.style.minHeight = avaiHeight + 'px'
        loginRightComponent.style.minHeight = avaiHeight + 'px'
    }
    else{
        loginLeftComponent.style.minHeight = 'auto'
        loginRightComponent.style.minHeight = 'auto'
    }
}

function setAnimationWhenFirstLoadingPage(): void{
    const loginComponent: HTMLElement = document.querySelector('.login')

    this.setTimeout(function(){
        loginComponent.classList.add('active')
    }, 200)
}

;(function(){
    window.addEventListener('load', function(){
        setMinHeightForLeftAndRightComponents()
        setAnimationWhenFirstLoadingPage()
    })

    window.addEventListener('resize', function(){
        setMinHeightForLeftAndRightComponents()
    })
})();