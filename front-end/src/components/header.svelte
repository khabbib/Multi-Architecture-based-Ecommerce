
<script>
    function login() {
        console.log('login')
    }
    function signUp() {
        console.log('signUp')
    }
</script>

<header>
    <nav class="flex items-center justify-between px-4 py-2 bg-blue-50">
            <div>
                <img class="h-12 w-12" src="./imgs/logo.png" alt="Image title">
            </div>
            <div class="text-gray flex items-center justify-between gap-10">
                <a class="text-gray-600 hover:text-gray-700" href="/">home</a>
                <a class="hover:text-gray-700" href="/product">product</a>
                <a class="hover:text-gray-700" href="/about">about</a>
            </div>
            <div class="flex items-center gap-3">
                <!--  
                <button class="py-2 px-4 bg-white text-black font-semibold rounded-md hover:opacity-0.5 focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-75" on:click={(e) => signUp()}>Sign up</button>
                <button class="py-2 px-4 bg-black text-white font-semibold rounded-md hover:opacity-0.5 focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-75" on:click={(e) => login()}>Login</button>
                -->
                <a class="py-2 px-4 bg-white text-black font-semibold rounded-md hover:opacity-0.5 focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-75" href="/register">Sign up</a>
                <a class="py-2 px-4 bg-black text-white font-semibold rounded-md hover:opacity-0.5 focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-75" href="/login">Login</a>
            </div>
    </nav>
</header>