package lth.com.hrm.HumanManagement.Controller;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getById/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(
                new ApiResponse(201, blogService.getById(id)));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.status(200).body(
                new ApiResponse(201, blogService.getAll()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody Blog blog) {
        return ResponseEntity.status(201).body(
                new ApiResponse(201, blogService.create(blog)));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/update")
    public ResponseEntity<ApiResponse> update(@RequestBody Blog blog) {
        if (blogService.getById(blog.getId()) == null) {
            return ResponseEntity.status(404).body(
                    new ApiResponse(404, "User not found", null));
        }
        blogService.update(blog);
        return ResponseEntity.status(200).body(
                new ApiResponse(200, "Update Success Fully", blog));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/delete")
    public ResponseEntity<ApiResponse> delete(@RequestBody Long id) {
        if (blogService.getById(id) == null) {
            return ResponseEntity.status(404).body(
                    new ApiResponse("User Not Found"));
        }
        blogService.delete(id);
        return ResponseEntity.status(200).body(
                new ApiResponse("Delete Success Fully"));
    }
}
