function renderCartEmpty(): void{
    const cartWrapper = document.querySelector('.cart-wrapper') as HTMLDivElement

    cartWrapper.innerHTML = `
    <div class="cart-empty">
        <div class="cart-empty-top">
            <h1 class="cart-empty-title">
                Giỏ hàng của bạn hiện đang trống
            </h1>
            <h2 class="cart-empty-suggestion">
                Hãy đăng nhập để xem giỏ hàng của bạn. Hoặc tiếp tục mua sắm thôi nào!
            </h2>
        </div>
        <div class="cart-empty-bottom">
            <a href="login.html" class="cart-empty-bottom-button cart-empty-login">
                Đăng nhập
            </a>
            <a href="index.html" class="cart-empty-bottom-button cart-empty-goShopping">
                Tiếp tục mua sắm
            </a>
        </div>
    </div>
    `
}


