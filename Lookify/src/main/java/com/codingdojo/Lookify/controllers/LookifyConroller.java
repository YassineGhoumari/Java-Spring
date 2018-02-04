package com.codingdojo.Lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LookifyConroller{
private final SongService songService;
	
	public LookifyController(SongService songService){
		this.songService = songService;
	}
	
	@RequestMapping("")
	public String index(){
		return "index";
	}

	@RequestMapping("dashboard")
	public String dashboard(Model model){
		model.addAttribute("songs",songService.all());
		return "dashboard";
	}
	
	@RequestMapping("songs/{id}")
	public String songs(@PathVariable("id") long id,Model model){
		model.addAttribute("song",songService.findById(id));
		return "song";
	}
	
	@RequestMapping("songs/new")
	public String newSong(Model model){
		model.addAttribute("song",new Song());
		return "new";
	}
	
	@PostMapping("songs/new")
	public String create(@Valid @ModelAttribute("song") Song song,BindingResult res,RedirectAttributes flash){
		if(res.hasErrors()){
			flash.addFlashAttribute("errs",res.getAllErrors());
			return "redirect:/songs/new";
		}else{
			songService.create(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("songs/delete/{id}")
	public String destroy(@PathVariable("id") long id){
		songService.destroy(id);
		return "redirect:/dashboard";
	}
		
	@PostMapping("/search")
	public String search(@RequestParam(value="artist") String artist,Model model){
		model.addAttribute("songs",songService.findByArtist(artist));
		return "search";
	}
	
	@RequestMapping("/songs/top10")
	public String top10(Model model){
		model.addAttribute("songs",songService.top10());
		return "top10";
	}
}

	
	
