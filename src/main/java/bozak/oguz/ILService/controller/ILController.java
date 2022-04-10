package bozak.oguz.ILService.controller;

import bozak.oguz.ILService.model.Il;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/iller")
public class ILController {
    private static final List<Il> iller=new ArrayList<>();

    public ILController(){
        if(iller.isEmpty()){
            Il il1=new Il(new Date(),"35","İzmir");
            Il il2=new Il(new Date(),"42","Konya");
            iller.add(il1);
            iller.add(il2);
        }

    }
    @GetMapping
    public ResponseEntity<List<Il>> getIller(){
        return new ResponseEntity<>(iller, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
        Il result= doFilter(id);
            return new ResponseEntity<>(result,HttpStatus.OK);
    }

    private Il doFilter(String id) {
        return iller.stream()
                .filter(il -> il.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("İl bulunamadı!!!"));
    }

    @PostMapping
    public ResponseEntity createIl(@RequestBody Il newIl){
        newIl.setCreateDate(new Date());
        iller.add(newIl);
        return new ResponseEntity<>(newIl,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id, @RequestBody Il newIl){
        Il oldIl=doFilter(id);
        oldIl.setName(newIl.getName());
        oldIl.setCreateDate(new Date());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Il> deleteIl(@PathVariable String id){
        Il il=doFilter(id);
        iller.remove(il);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
