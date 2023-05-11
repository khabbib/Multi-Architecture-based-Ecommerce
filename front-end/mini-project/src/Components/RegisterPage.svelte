This is register package

<br>

<a
  class="blue"
  sveltekit:prefetch
  in:receive={{ key: "block" }}
  out:send={{ key: "block" }} 
	href="/Header"
  on:click|preventDefault={() => (route = "/Header")}>
	Go to Header
</a>

<script>
    import { send, receive } from "../lib/libPageCrossfade.js"; // $lib/pageCrossfade.js
</script>