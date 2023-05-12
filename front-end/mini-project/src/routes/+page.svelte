<!-- 
<h1>Welcome to your library project</h1>
<p>Create your package using @sveltejs/package and preview/showcase your work with SvelteKit</p>
<p>Visit <a href="https://kit.svelte.dev">kit.svelte.dev</a> to read the documentation</p>
-->

<script>
    import "../app.css";
    import RegisterPage from '../routes/RegisterPage.svelte';
    import LoginPage from '../routes/LoginPage.svelte';
    import HeaderPage from '../Components/HeaderPage.svelte';

    let route = '/Register'; // REPL alternative to routing
</script>

<HeaderPage />

<h1 class="text-3xl font-bold underline">Hello world!</h1>
  
<style lang="postcss">
    :global(html) {
      background-color: whitesmoke;
    }
</style>

<!-- if stamement and bind:route to mimic a router in the REPL 
{#if route == '/Header'}
  <RegisterPage bind:route />
{:else}
  <HeaderPage bind:route />
{/if}
-->

