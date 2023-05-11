<!-- 
<h1>Welcome to your library project</h1>
<p>Create your package using @sveltejs/package and preview/showcase your work with SvelteKit</p>
<p>Visit <a href="https://kit.svelte.dev">kit.svelte.dev</a> to read the documentation</p>
-->

<style>
    h1 {
        color: rgb(29, 126, 29);
    }
</style>

<script>
    import RegisterPage from '../Components/RegisterPage.svelte';
    import HeaderPage from '../Components/HeaderPage.svelte';

    let route = '/Register'; // REPL alternative to routing
</script>

<!-- if stamement and bind:route to mimic a router in the REPL -->
{#if route == '/Register'}
  <RegisterPage bind:route />
{:else}
  <HeaderPage bind:route />
{/if}


