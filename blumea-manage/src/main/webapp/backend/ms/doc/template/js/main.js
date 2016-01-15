$(document).ready(function(){

	/*
	 * Navigation
	 */

	var arrow_class_open   = 'icon-angle-down',
		arrow_class_closed = 'icon-angle-left';

	$('li:has(ul)', 'ul#nav').each(function() {
		if ($(this).hasClass('current') || $(this).hasClass('open-default')) {
			$('>a', this).append("<i class='arrow " + arrow_class_open + "'></i>");
		} else {
			$('>a', this).append("<i class='arrow " + arrow_class_closed + "'></i>");
		}
	});

	function submenuHandler(_this) {
		if ($(_this).next().hasClass('sub-menu') == false) {
			return;
		}

		var sub = $(_this).next();
		if (sub.is(":visible")) {
			$('i.arrow', $(_this)).removeClass(arrow_class_open).addClass(arrow_class_closed);
			$(_this).parent().removeClass('open');
			sub.slideUp(200, function() {
				$(_this).parent().removeClass('open-fixed').removeClass('open-default');
			});
		} else {
			$('i.arrow', $(_this)).removeClass(arrow_class_closed).addClass(arrow_class_open);
			$(_this).parent().addClass('open');
			sub.slideDown(200);
		}
	}

	$('ul#nav > li > a').on('click', function (e) {
		$('li:has(ul)', 'ul#nav').each(function() {
			var sub = $(this).find('.sub-menu');
			sub.slideUp(200);
			sub.parent().find('>a i.arrow').removeClass(arrow_class_open).addClass(arrow_class_closed);

			$(this).removeClass('open');
		});

		submenuHandler(this);

		e.preventDefault();
	});

	/*
	 * One Page Nav
	 */

	$('#nav').onePageNav({
		currentClass: 'current',
		changeHash: true,
		scrollSpeed: 750,
		scrollOffset: 0,
		scrollThreshold: 0.5,
		filter: '',
		easing: 'swing',
		begin: function() {
			//Hack so you can click other menu items after the initial click
			$('body').append('<div id="device-dummy" style="height: 1px;"></div>');
		},
		end: function() {
			$('#device-dummy').remove();
		},
		scrollChange: function($currentListItem) {
			// I get fired when you enter a section and I pass the list item of the section

			var submenu = $currentListItem.parent();

			submenu.parent().find('li:has(ul)').each(function () {
				var sub = $(this).find('.sub-menu');
				sub.slideUp(200);
				sub.parent().find('>a i.arrow').removeClass(arrow_class_open).addClass(arrow_class_closed);

				$(this).removeClass('open');
			});

			if (submenu.hasClass('sub-menu')) {
				submenu.parent().addClass('open');
				submenu.parent().find('>a i.arrow').removeClass(arrow_class_closed).addClass(arrow_class_open);
				$currentListItem.parent().addClass('open');
				submenu.slideDown(200);
			}
		}
	});

	/*
	 * SyntaxHighlighter
	 */

	function path()
	{
	  var args = arguments,
		  result = []
		  ;
		   
	  for(var i = 0; i < args.length; i++)
		  result.push(args[i].replace('@', 'template/js/plugins/syntaxhighlighter/'));

	  return result
	};
 
	SyntaxHighlighter.autoloader.apply(null, path(
	  'applescript            @shBrushAppleScript.js',
	  'actionscript3 as3      @shBrushAS3.js',
	  'bash shell             @shBrushBash.js',
	  'coldfusion cf          @shBrushColdFusion.js',
	  'cpp c                  @shBrushCpp.js',
	  'c# c-sharp csharp      @shBrushCSharp.js',
	  'css                    @shBrushCss.js',
	  'delphi pascal          @shBrushDelphi.js',
	  'diff patch pas         @shBrushDiff.js',
	  'erl erlang             @shBrushErlang.js',
	  'groovy                 @shBrushGroovy.js',
	  'java                   @shBrushJava.js',
	  'jfx javafx             @shBrushJavaFX.js',
	  'js jscript javascript  @shBrushJScript.js',
	  'perl pl                @shBrushPerl.js',
	  'php                    @shBrushPhp.js',
	  'text plain             @shBrushPlain.js',
	  'py python              @shBrushPython.js',
	  'ruby rails ror rb      @shBrushRuby.js',
	  'sass scss              @shBrushSass.js',
	  'scala                  @shBrushScala.js',
	  'sql                    @shBrushSql.js',
	  'vb vbnet               @shBrushVb.js',
	  'xml xhtml xslt html    @shBrushXml.js'
	));
	SyntaxHighlighter.all();
});