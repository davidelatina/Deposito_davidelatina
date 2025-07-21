package com.example.demo.controller;


import com.example.demo.model.DemoObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/demoobjects")
public class DemoObjectController {

  private List<DemoObject> demoObjects = new ArrayList<>();
  private Long idCounter = 1L;

  @GetMapping
  public List<DemoObject> getAll() {
    return demoObjects;
  }

  @PostMapping
  public DemoObject create(@RequestBody DemoObject newDemoObject) {
    newDemoObject.setId(idCounter++);
    demoObjects.add(newDemoObject);
    return newDemoObject;
  }

  @GetMapping("/{id}")
  public DemoObject getById(@PathVariable Long id) {
    return demoObjects.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DemoObject> update(@PathVariable Long id, @RequestBody DemoObject modified) {
    for (DemoObject d : demoObjects) {
      if (d.getId().equals(id)) {
        d.setNumber(modified.getNumber());
        return ResponseEntity.ok(d);
      }
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id) {
    demoObjects.removeIf(p -> p.getId().equals(id));
    return "Object deleted successfully.";
  }

  @GetMapping("/sum")
  public int sum() {

    return demoObjects.stream().mapToInt(DemoObject::getNumber).sum();
  }
}
