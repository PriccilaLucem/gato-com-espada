document.addEventListener("DOMContentLoaded", () => {
    const canvas = document.getElementById("game");
    const ctx = canvas.getContext("2d");

    ctx.canvas.width = window.innerWidth;
    ctx.canvas.height = window.innerHeight;

    ctx.fillStyle = "#d5a2f6";
    ctx.fillRect(0, 0, ctx.canvas.width, ctx.canvas.height);
})
